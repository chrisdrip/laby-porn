package com.github.chrissdrip.laby.porn.module;

import com.github.chrissdrip.laby.porn.LabyPorn;
import com.github.chrissdrip.laby.porn.util.NumberFormatter;
import com.github.chrissdrip.laby.porn.util.PornHubUtil;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class ViewsModule extends SimpleModule {

  private final PornHubUtil pornHubUtil;

  public ViewsModule(PornHubUtil pornHubUtil) {
    this.pornHubUtil = pornHubUtil;
  }

  @Override
  public String getDisplayName() {
    return "Views";
  }

  @Override
  public String getDisplayValue() {
    if (this.pornHubUtil.getLastStatus() != null) {
      return this.pornHubUtil.getLastStatus();
    }

    return NumberFormatter.formatNumber(this.pornHubUtil.getCurrentInformation().getViews());
  }

  @Override
  public String getDefaultValue() {
    return "-";
  }

  @Override
  public ControlElement.IconData getIconData() {
    return new ControlElement.IconData(Material.WOOD_BUTTON);
  }

  @Override
  public void loadSettings() {

  }

  @Override
  public String getControlName() {
    return "Views";
  }

  @Override
  public String getSettingName() {
    return "PornHub Views";
  }

  @Override
  public String getDescription() {
    return "Displays the PornHub views of your favourite channel.";
  }

  @Override
  public int getSortingId() {
    return 0;
  }

  @Override
  public ModuleCategory getCategory() {
    return LabyPorn.MODULE_CATEGORY;
  }

}