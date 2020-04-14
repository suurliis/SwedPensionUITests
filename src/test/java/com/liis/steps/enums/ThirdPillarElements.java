package com.liis.steps.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ThirdPillarElements {

    CHOOSE_V_FUND_BUTTON("#p3InvestmentsHead > div > table > tfoot > tr > td:nth-child(3) > p:nth-child(1) > a"),
    ENTER_INTO_AGREEMENT_BUTTON("#p3InvestmentsHead > div > table > tfoot > tr > td:nth-child(2) > p:nth-child(1) > a"),
    SWEDBANK_V_FUND_PAGE_TITLE("#contentHead > h1"),
    START_SAVING_BUTTON("#mainForm > section:nth-child(12) > div > div.form-button-bar > a:nth-child(2)");

    private String pillarElement;
}
