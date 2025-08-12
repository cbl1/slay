package examplemod.modcore;
import com.badlogic.gdx.graphics.Color;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import examplemod.cards.ExampleStrike;

@SpireInitializer
public class ExampleMod implements EditCardsSubscriber, EditStringsSubscriber { // 实现接口
    private static final String MY_CHARACTER_BUTTON = "ExampleModResources/img/char/Character_Button.png";
    // 人物选择界面的立绘
    private static final String MY_CHARACTER_PORTRAIT = "ExampleModResources/img/char/Character_Portrait.png";
    // 攻击牌的背景（小尺寸）
    private static final String BG_ATTACK_512 = "ExampleModResources/img/512/bg_attack_512.png";
    // 能力牌的背景（小尺寸）
    private static final String BG_POWER_512 = "ExampleModResources/img/512/bg_power_512.png";
    // 技能牌的背景（小尺寸）
    private static final String BG_SKILL_512 = "ExampleModResources/img/512/bg_skill_512.png";
    // 在卡牌和遗物描述中的能量图标
    private static final String SMALL_ORB = "ExampleModResources/img/char/small_orb.png";
    // 攻击牌的背景（大尺寸）
    private static final String BG_ATTACK_1024 = "ExampleModResources/img/1024/bg_attack.png";
    // 能力牌的背景（大尺寸）
    private static final String BG_POWER_1024 = "ExampleModResources/img/1024/bg_power.png";
    // 技能牌的背景（大尺寸）
    private static final String BG_SKILL_1024 = "ExampleModResources/img/1024/bg_skill.png";
    // 在卡牌预览界面的能量图标
    private static final String BIG_ORB = "ExampleModResources/img/char/card_orb.png";
    // 小尺寸的能量图标（战斗中，牌堆预览）
    private static final String ENEYGY_ORB = "ExampleModResources/img/char/cost_orb.png";
    public static final Color MY_COLOR = new Color(236.0F / 255.0F, 192.0F / 255.0F, 170.0F / 255.0F, 1.0F);
    public ExampleMod() {
        BaseMod.subscribe(this); // 告诉basemod你要订阅事件
        BaseMod.addColor(EXAMPLE_GREEN, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR,BG_ATTACK_512,BG_SKILL_512,BG_POWER_512,ENEYGY_ORB,BG_ATTACK_1024,BG_SKILL_1024,BG_POWER_1024,BIG_ORB,SMALL_ORB);
    }

    public static void initialize() {
        new ExampleMod();
    }

    // 当basemod开始注册mod卡牌时，便会调用这个函数
    @Override
    public void receiveEditCards() {
        // 向basemod注册卡牌
        BaseMod.addCard(new ExampleStrike());
    }

    public void receiveEditStrings(){
        String lang;
        if (Settings.language == Settings.GameLanguage.ZHS) {
            lang = "ZHS"; // 如果语言设置为简体中文，则加载ZHS文件夹的资源
        } else {
            lang = "ENG"; // 如果没有相应语言的版本，默认加载英语
        }
        BaseMod.loadCustomStringsFile(CardStrings.class, "ExampleModResources/localization/" + lang + "/cards.json"); // 加载相应语言的卡牌本地化内容。
        // 如果是中文，加载的就是"ExampleResources/localization/ZHS/cards.json"
    }



}
