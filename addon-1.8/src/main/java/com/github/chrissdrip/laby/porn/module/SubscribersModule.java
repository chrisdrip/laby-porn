package com.github.chrissdrip.laby.porn.module;

import com.github.chrissdrip.laby.porn.util.NumberFormatter;
import com.github.chrissdrip.laby.porn.util.PornHubUtil;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class SubscribersModule extends SimpleModule {

  private final PornHubUtil pornHubUtil;

  public SubscribersModule(PornHubUtil pornHubUtil) {
    this.pornHubUtil = pornHubUtil;
  }

  @Override
  public String getDisplayName() {
    return "Subscribers";
  }

  @Override
  public String getDisplayValue() {
    if (this.pornHubUtil.getLastStatus() != null) {
      return this.pornHubUtil.getLastStatus();
    }

    return NumberFormatter.formatNumber(this.pornHubUtil.getCurrentInformation().getSubscribers());
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
    return "Subscribers";
  }

  @Override
  public String getSettingName() {
    return "PornHub Subscribers";
  }

  @Override
  public String getDescription() {
    return "Displays the PornHub subscribers count of your favorite channel.";
  }

  @Override
  public int getSortingId() {
    return 0;
  }
}