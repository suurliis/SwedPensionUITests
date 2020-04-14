package com.liis.steps.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FundRatesElements {
    SWEDBANK_PENSION_FUND_K60_PAGE("#tableRow3 > td:nth-child(2) > a"),
    PENSION_FUND_K60_PERFORMANCE_TAB("#Tab3 > a"),
    PENSION_FUND_PRICES_HISTORY_LINK("#mainForm > section:nth-child(13) > p > a"),
    PENSION_FUND_K60_SECURITY_TYPE_SELECT_VALUE("#mainForm > section > ui-field:nth-child(1) > div.ui-field__control > select > option:nth-child(2)"),
    PENSION_FUND_K60_CURRENCY_SELECT_VALUE("#mainForm > section > ui-field:nth-child(2) > div.ui-field__control > select > option:nth-child(1)"),
    PENSION_FUND_K60_SECURITY_SELECT_VALUE("#mainForm > section > ui-field:nth-child(3) > div.ui-field__control > select > option:nth-child(243)");

    private String ratesElement;
}
