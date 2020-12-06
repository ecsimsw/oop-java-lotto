package domain;

import utils.InputValidator;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        InputValidator.checkValidWinningLotto(lotto, bonusNo);
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = this.lotto.getCountOfMatch(userLotto);
        boolean matchBonus = userLotto.contains(bonusNo);
        return Rank.valueOf(matchCount, matchBonus);
    }
}
