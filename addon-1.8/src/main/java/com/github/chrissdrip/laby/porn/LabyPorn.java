package com.github.chrissdrip.laby.porn;

import com.github.chrissdrip.laby.porn.module.RankingModule;
import com.github.chrissdrip.laby.porn.module.SubscribersModule;
import com.github.chrissdrip.laby.porn.module.ViewsModule;
import com.github.chrissdrip.laby.porn.util.PornHubUtil;
import java.util.List;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.settings.elements.StringElement;
import net.labymod.utils.Material;

public class LabyPorn extends LabyModAddon {

  private final PornHubUtil pornHubUtil = new PornHubUtil();

  @Override
  public void onEnable() {
    super.getApi().registerModule(new RankingModule(pornHubUtil));
    super.getApi().registerModule(new SubscribersModule(pornHubUtil));
    super.getApi().registerModule(new ViewsModule(pornHubUtil));
  }

  @Override
  public void loadConfig() {
    if (!super.getConfig().has("pornHubName")) {
      super.getConfig().addProperty("pornHubName", "");
    }

    this.pornHubUtil.startUpdater(super.getConfig());
  }

  @Override
  protected void fillSettings(List<SettingsElement> list) {
    list.add(new StringElement("PornHub Name", new ControlElement.IconData(Material.NAME_TAG), super.getConfig().get("pornHubName").getAsString(), changedValue -> {
      super.getConfig().addProperty("pornHubName", changedValue);
    }));
  }

}