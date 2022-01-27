package com.github.chrissdrip.laby.porn.util;

public class NumberFormatter {

  public static String formatNumber(long number) {
    if (number <= 9999) {
      // < 10 K
      return String.valueOf(number);
    }

    if (number < 1_000_000) {
      // < 1 Mio
      return String.format("%.1f", number / 1_000D).replace(',', '.') + " K";
    }

    if (number < 1_000_000_000) {
      // < 1 Mrd
      return String.format("%.1f", number / 1_000_000D).replace(',', '.') + " Mio";
    }

    // >= 1 Mrd
    return String.format("%.1f", number / 1_000_000_000D).replace(',', '.') + " Mrd";
  }

}
