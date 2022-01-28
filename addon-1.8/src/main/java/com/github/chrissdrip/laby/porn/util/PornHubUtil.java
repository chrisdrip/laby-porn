package com.github.chrissdrip.laby.porn.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PornHubUtil {

  private static final Gson GSON = new Gson();
  private static final JsonParser JSON_PARSER = new JsonParser();
  private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);

  private String currentName;

  private String lastStatus;

  private ModelInformation currentInformation;

  public void startUpdater(JsonObject config) {
    EXECUTOR_SERVICE.scheduleAtFixedRate(() -> {
      this.currentName = config.get("pornHubName").getAsString();
      if (this.currentName.isEmpty()) {
        this.updateError("Please set the model name in the addon settings.");
        return;
      }

      try {
        final HttpURLConnection con = (HttpURLConnection) new URL("http://webutil.hdskins.de/pornhub/model/" + this.currentName).openConnection();
        con.connect();

        if (con.getResponseCode() == 502) {
          this.updateError("Please check your internet connection or wait a few minutes.");
        }

        try (InputStreamReader inputStreamReader = new InputStreamReader(
            con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream())) {
          if (con.getResponseCode() == 200) {
            this.currentInformation = GSON.fromJson(inputStreamReader, ModelInformation.class);
            this.lastStatus = null;
          } else {
            this.updateError(JSON_PARSER.parse(inputStreamReader).getAsJsonObject().get("error").getAsString());
          }

          con.disconnect();
        }

      } catch (IOException ex) {
        this.updateError("Please check your internet connection or wait a few minutes.");
      }
    }, 0L, 3L, TimeUnit.SECONDS);
  }

  private void updateError(String error) {
    this.currentInformation = null;
    this.lastStatus = error;
  }

  public String getLastStatus() {
    return this.lastStatus;
  }

  public ModelInformation getCurrentInformation() {
    return this.currentInformation;
  }
}