package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    private WinningLotto(Lotto lotto, int bonusNo) {
        // bonus 숫자 범위
        // bonus가 lotto에 포함되진 않는지 체크
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public static WinningLotto create(Lotto lotto, int bonus){
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        return winningLotto;
    }

    public Rank match(Lotto userLotto) {
        int matchPoint = userLotto.getMatchPoint(userLotto);
        boolean isMatchBonus = userLotto.isInclude(bonusNo);
        return Rank.valueOf(matchPoint, isMatchBonus);
    }
}