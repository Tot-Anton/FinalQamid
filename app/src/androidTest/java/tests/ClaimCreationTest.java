package tests;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import steps.AuthorizationSteps;
import steps.ClaimCreationSteps;
import steps.ClaimsSteps;
import steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.AppActivity;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AllureAndroidJUnit4.class)
public class ClaimCreationTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void logIn() throws InterruptedException {
        Thread.sleep(7000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.logIn("login2", "password2");
    }

    @Test
    @DisplayName("Создание заявки при вводе валидных данных во все поля <50 символов")
    public void shouldCreateClaimWithValidData() {
        String emptyTitle = "no";
        String title = "NeSudiStrogo";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Slogno mne pisat Diplom";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelSteps.goToClaimsBlock();
        ClaimsSteps.initiateTheCreationOfClaim();
        ClaimCreationSteps.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationSteps.saveClaim();
        ClaimsSteps.checkCreatedClaimInClaimsBlock(title);
    }


    @Test
    @DisplayName("ввод 50 символов в поле Тема при создании заявки")
    public void shouldInput50SymbolsInTitleDuringClaimCreation() {
        String emptyTitle = "no";
        String title50 = "VremyaNeHvataetNaDiplom24VremyaNeHvataetNaDiplom24";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Slogno mne pisat Diplom";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelSteps.goToClaimsBlock();
        ClaimsSteps.initiateTheCreationOfClaim();
        ClaimCreationSteps.fillInTheClaimFields(emptyTitle, title50, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationSteps.saveClaim();
        ClaimsSteps.checkCreatedClaimInClaimsBlock(title50);
    }

    @Test
    @DisplayName("Ввод 51 символ в поле Тема при создании заявки")
    public void shouldInput51SymbolsInTitleDuringClaimCreation() {
        String emptyTitle = "no";
        String title51 = "VremyaNeHvataetNaDiplom24VremyaNeHvataetNaDiplom24+";
        String titleOfCreatedClaim = "VremyaNeHvataetNaDiplom24VremyaNeHvataetNaDiplom24";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Slogno mne pisat Diplom";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelSteps.goToClaimsBlock();
        ClaimsSteps.initiateTheCreationOfClaim();
        ClaimCreationSteps.fillInTheClaimFields(emptyTitle, title51, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationSteps.saveClaim();
        ClaimsSteps.checkCreatedClaimInClaimsBlock(titleOfCreatedClaim);
    }

    @Test
    @DisplayName("Пустой ввод в поле Тема при создании заявки")
    public void shouldTryCreateClaimWithEmptyTitle() {
        String emptyTitle = "yes";
        String title = "no";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelSteps.goToClaimsBlock();
        ClaimsSteps.initiateTheCreationOfClaim();
        ClaimCreationSteps.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationSteps.saveClaim();
        ClaimCreationSteps.checkMessageThatFieldsShouldBeFilled(activityTestRule);
    }



}
