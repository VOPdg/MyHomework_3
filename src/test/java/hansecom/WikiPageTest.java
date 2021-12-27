package hansecom;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WikiPageTest {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1280x800";
    }

    @Test
    void successTest() throws InterruptedException {
        // открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        // убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("button.f6").click();
        $("#wiki-pages-box").$$("li a").shouldHave(itemWithText("SoftAssertions"));
        // открыть страницу SoftAssertions, проверить что внутри есть пример кода для JUnit5
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));

    }
}

