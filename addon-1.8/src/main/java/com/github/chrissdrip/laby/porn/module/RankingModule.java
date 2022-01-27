package com.github.chrissdrip.laby.porn.module;

import com.github.chrissdrip.laby.porn.util.PornHubUtil;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class RankingModule extends SimpleModule {

  private final PornHubUtil pornHubUtil;

  public RankingModule(PornHubUtil pornHubUtil) {
    this.pornHubUtil = pornHubUtil;
  }

  @Override
  public String getDisplayName() {
    return "Rank";
  }

  @Override
  public String getDisplayValue() {
    if (this.pornHubUtil.getLastStatus() != null) {
      return this.pornHubUtil.getLastStatus();
    }

    return String.valueOf(this.pornHubUtil.getCurrentInformation().getRank());
  }

  @Override
  public String getDefaultValue() {
    return "-";
  }

  @Override
  public ControlElement.IconData getIconData() {
    return new ControlElement.IconData(Material.BEACON);
  }

  @Override
  public void loadSettings() {

  }

  @Override
  public String getControlName() {
    return "Rank";
  }

  @Override
  public String getSettingName() {
    return "PornHub Rank";
  }

  @Override
  public String getDescription() {
    return "Displays the PornHub rank of your favourite channel.";
  }

  @Override
  public int getSortingId() {
    return 0;
  }
}