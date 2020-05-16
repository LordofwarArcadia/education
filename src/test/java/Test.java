import org.junit.Before;
import pages.CashCreditPage;
import pages.HomePage;

import java.util.List;


public class Test extends AbstractTestBase {

    @org.junit.Test
    public void doSomeShit() {
        //fillMoneyAmountAndSubmit(""); // <--наследование нельзя
    }

    @org.junit.Test
    public void doSomeValidShit() {
        CashCreditPage cp = new CashCreditPage(driver); //инстанциирование
        cp.submitMonthAmount(); //и работа с объектом - V!!!
    }

    @org.junit.Test
    public void transferFromHomePageToCashCredit() {
        //инициализируем "прокси" для домашней страницы
        HomePage hp = new HomePage(driver);
        //скрыто проверяется что мы имеем тайтл хоум пейджа
        hp.menu.clickOnMenuItem("Рабство", "Рабство налом");

        //инициализируем "прокси" для страницы с кредитами
        CashCreditPage cp = new CashCreditPage(driver);
        //скрыто проверяется что мы имеем тайтл кредита наличными

        //выполняем действие у объекта (через "прокси" - наш фрейм)
        cp.fillMoneyAmountAndSubmit("100000");

        assert true;
        //проверяем что состояние объекта совпадает с эталоном.
    }

    @org.junit.Test
    public void maximumMonthValueDependsOnCheckBoxTest() {
        /*
        1) Открыть страницу с кредитом наличными
        2) Ввести 100000 в поле денег
        3) Установить чекбокс в "Да"
        4) Ввести 60 в поле месяцев
        5) Проверить что максимальный срок составляет 60 месяцев
        */

        //1 шаг - открыть страницу
        //инициализируем "прокси" для страницы с кредитами
        //Given Im on CashCredit Page
        CashCreditPage cp = new CashCreditPage(driver);
        //скрыто проверяется что мы имеем тайтл кредита наличными

        //2 шаг - ввести 100000 в поле денег
        //When I put 100000 into Money
        cp.fillMoneyAmountAndSubmit("100000");

        //3 шаг - выставить чекбокс на форме в ДА
        // And I check checkbox to true
        cp.checkCheckbox(true);

        //4 шаг - ввести 60 в поле месяцев
        // And I put 60 in months amount
        cp.fillMonthAmount(60);

        //5 шаг - ассёрт
        // Then I could see 60 месяцев in months value
        assert cp.getMonthsText().equals("60 месяцев");
    }

    @Before
    public void openHomeAccountPage() {
        //Каким то образом зашли в личный кабинет
        // создали для этого какой-то метод в AbstractTestBase
        // например: зайти на сбер онлайн и ввести логин-пароль-код
        // или зайти на сбер онлайн подставив драйверу валидный access-token
        //сымитировав СМС/Биометрию/Пин-код/Что-то еще
        HomeAccountPage hap = new HomeAccountPage();
        // раскрыли  область со страховыми продуктами
        hap.popupInsuranceArea();
        // нажали на кнопку "Оформляли страховку ранее"
        hap.clickPlusButton();
    }

    @org.junit.Test
    // А ЭТО ТЕСТ
    public void baseInsuranceTest() {
        openHomeAccountPage();
        // ожидаем что согласия не было
        //и нам показывается эта страничка
        BaseSoglasiePage bsp = new BaseSoglasiePage();
        // чекнули чекбокс
        bsp.setCheckBoxSoglasieTo(true);
        // нажали на "продолжить"
        bsp.clickProdolgit();
        // слишком долго грузится - ждем
        bsp.waitUntilInfoWillBeLoaded();
    }

    @org.junit.Test
    public void getListOfUsedInsuranceProductsTest() {
        //Согласие уже дано, следовательно страницу согласия не посещаем
        // А сразу на страницу со страховками
        InsurancePage ip = new InsurancePage();
        //получаем список уже работающих продуктов
        List<Object> result = ip.getListOfInsuranceProductsAlreadyUsed();

        //проверяем что у нашего юзера уже действует 3 страховки
        assert result.size() == 3;
        //проверяем их поля
    }

    @org.junit.Test
    public void getListOfAvailableInsuranceProductsTest() {
        //Согласие уже дано, следовательно страницу согласия не посещаем
        // А сразу на страницу со страховками
        InsurancePage ip = new InsurancePage();
        //получаем список продуктов, доступных к приобретению
        List<Object> result = ip.getListOfInsuranceProductsAvailableToUse();

        //проверяем что нашему юзеру предлагают 5 разных страховок
        assert result.size() == 5;
        //проверяем их поля
    }

    @org.junit.Test
    public void getListOfAvailableInsuranceProductsIfSomeAlreadyUsedTest() {
        //Согласие уже дано, следовательно страницу согласия не посещаем
        // А сразу на страницу со страховками
        InsurancePage ip = new InsurancePage();
        //получаем список продуктов, доступных к приобретению
        List<Object> result = ip.getListOfInsuranceProductsAvailableToUse();
        List<Object> resultUsed = ip.getListOfInsuranceProductsAlreadyUsed();

        //проверяем что всего 5 страховых продуктов
        // нашему юзеру предлагают 4 разных страховок
        // потому что одна у него уже действует
        assert result.size() == 4;
        assert resultUsed.size() == 1;
        //проверяем их поля
    }

    @org.junit.Test
    public void buyNewInsuranceProductTest() {
        //Согласие уже дано, следовательно страницу согласия не посещаем
        // А сразу на страницу со страховками
        InsurancePage ip = new InsurancePage();
        //ищем по имени и выбираем страховку
        ip.clickAtInsuranceProductByName("Страхование жизни.");

        //проверяем что наш юзер попадает на экран ввода персональных данных
        // и они совпадают с реальными данными пользователя
        assert ip.checkPersonalDataFormIsValid("Александр", "Кобченко");
        //повторяем то же самое для формы инфы о страховке и т.п.
    }

    // В ПЕЙДЖ ОБЖЕКТ В МЕЙНЕ
    class HomeAccountPage {

        public void popupInsuranceArea() {
            // нашли треугольник
            // проскроллили до него
            // кликнули на треугольник
            // подождали пока раскроется область
        }

        public void clickPlusButton() {
            // нажать на кнопочку "Оформляли ранее?"
        }
    }

    // В ПЕЙДЖ ОБЖЕКТ В МЕЙНЕ
    class BaseSoglasiePage {

        public void setCheckBoxSoglasieTo(Boolean to) {
            //установить чекбокс "Согласен" в положение to
        }

        public void clickProdolgit() {
            //кликнуть/тапнуть по кнопке продолжить
        }

        public void waitUntilInfoWillBeLoaded() {
            //тормозит ссука, ждем пока грузится
            // раз в 3 секунды ждем что лоадер (круглая хъерня) исчезнет
            // выход когда лоадер исчез
            // если лоадер не исчез за 30 секунд - провал теста - кидает Эксепшн
        }
    }

    class InsurancePage {

        public List<Object> getListOfInsuranceProductsAlreadyUsed() {
            // собираем по странице через ВД элементы, которые уже купили
            // и возвращаем в виде списка
            // для каждого "дива" сделать следующее:
            //      Создать новый объект ip класса InsuranceProduct(title, from, to, cost);
            //          var webElementOfInsuranceProduct = driver.findElementBy('//*[.='имя-страховки']');
            //          ip.from = webElementOfInsuranceProduct.getAttribute("from");
            //          ip.to = webElementOfInsuranceProduct.getAttribute("to");
            //          ip.title = webElementOfInsuranceProduct.getText();
            //          var cost = webElementOfInsuranceProduct.findElementBy(By.xpath("./div[@class='cost']"));
            //          ip.cost = cost==null ? null : cost.getText();
            // <div from=01.12.19 to=01.12.20>
            //      "Страхование жизни"
            //      <div class=cost>
            //          50000
            //      </>
            // </div>
            //       Добавить созданный объект с установленными полями в лист результата
            //       Вернуть лист результатов (List<InsuranceProduct>)
            return null;
        }

        public List<Object> getListOfInsuranceProductsAvailableToUse() {
            return null;
        }

        public void clickAtInsuranceProductByName(String name) {
            // ищем продукт с указанным неймом
            // не находим - эксепшн
            // находим - нажимаем
            // ждем перехода на следующую страницу
        }

        public boolean checkPersonalDataFormIsValid(String firstName, String lastName) {
            // мы проверяем что форма открыта, есть ФИО на форме и какой-то текст
            return true;
        }
    }


}
