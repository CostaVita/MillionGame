package com.firstmil.milliongame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.firstmil.milliongame.QuizContr.*;
import java.util.ArrayList;
import java.util.Random;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyMilQuiz.db";
    private static final int DATABASE_VERSION = 6;

    private SQLiteDatabase db;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.GAME_COUNT + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        QuestionModel q1 = new QuestionModel ("Как называется верхнее ребро крыши деревенского дома?", "Козлик", "Барашек", "Конёк", "Бычок", 3, 1);
        addQuestion(q1);
        QuestionModel q2 = new QuestionModel ("Для чего используется прибор Эхолот", "Для измерения глубин", "Для поиска металлов", "Для измерения эха в пещерах", "Для ловли акул", 1,1);
        addQuestion(q2);
        QuestionModel q3 = new QuestionModel ("Какие украшения появляются весной на берёзах?", "Брошки", "Серёжки", "Бусики", "Фенечки", 2,1);
        addQuestion(q3);
        QuestionModel q4 = new QuestionModel ("Кто в сказке Всеволода Гаршина помог лягушке стать путешественницей?", "Экскурсоводы", "Пилоты", "Утки", "Спонсоры", 3,1);
        addQuestion(q4);
        QuestionModel q5 = new QuestionModel ("Какое выражение стало нарицательным?", "Нос дедушки Крылова", "Лафонентово ухо", "Эзопов язык", "Сумароков зуб", 3,1);
        addQuestion(q5);
        QuestionModel q6 = new QuestionModel ("Как правильно закончить пословицу: Или грудь в крестах, или...", "Страшный страх", "Голова в кустах", "Мозги не в тех местах", "Полных швах", 2,1);
        addQuestion(q6);
        QuestionModel q7 = new QuestionModel ("Что, согласно пословице, является всему головой?", "Колбаса", "Хлеб", "Зрелище", "Булка", 2,1);
        addQuestion(q7);
        QuestionModel q8 = new QuestionModel ("Какое из этих имён в буквальном переводе означает фиалка", "Виола", "Зина", "Лиза", "Магда", 1,1);
        addQuestion(q8);
        QuestionModel q9 = new QuestionModel ("Где играли свадьбу герои популярной советской комедии 60-х?", "В Малиновке", "В Клубниковке", "В Крыжовинке", "В Смородинке", 1,1);
        addQuestion(q9);
        QuestionModel q10 = new QuestionModel ("Что надевается на диск автомобильного колеса?", "Подножка", "Подложка", "Покрышка", "Подстёжка", 3,1);
        addQuestion(q10);
        QuestionModel q11 = new QuestionModel ("Что должен был отвечать солдат Советской армии в ответ на благодарность командира?", "Не за что!", "Рад стараться!", "Служу Советскому Союзу!", "Ах, оставьте!", 3,2);
        addQuestion(q11);
        QuestionModel q12 = new QuestionModel ("Кто написал книгу Приключения Тома Сойера", "Антуан де Сент-Экзюпери", "Гомер", "Марк Твен", "Александр Пушкин", 3,2);
        addQuestion(q12);
        QuestionModel q13 = new QuestionModel ("О какой палате мы узнали благодаря Антону Павловичу Чехову?", "О палате 6", "О Грановитой палате", "Об Оружейной палате", "Об ума палате", 1,2);
        addQuestion(q13);
        QuestionModel q14 = new QuestionModel ("С каким материалом работает гончар?", "Камень", "Металл", "Дерево", "Глина", 4,2);
        addQuestion(q14);
        QuestionModel q15 = new QuestionModel ("Что используют для поджаривания ломтиков хлеба?", "Тостер", "Постер", "Винчестер", "Компостер", 1,2);
        addQuestion(q15);
        QuestionModel q16 = new QuestionModel ("Кого или что традиционно бросает на свадьбе невеста?", "Упрёки", "Жениха", "Курить", "Букет", 4,2);
        addQuestion(q16);
        QuestionModel q17 = new QuestionModel ("Какой вид спорта входит в программу зимних Олимпиад?", "Конкур", "Триатлон", "Бейсбол", "Биатлон", 4,2);
        addQuestion(q17);
        QuestionModel q18 = new QuestionModel ("С помощью какого оптического прибора рассматривал дам в театре Евгений Онегин?", "Пенсне", "Монокль", "Лорнет", "Лупа", 3,2);
        addQuestion(q18);
        QuestionModel q19 = new QuestionModel ("Как заканчивается фраза жадного человека: Не съем, так...", "Добавлю в пиццу", "Сварю варенье", "Испеку шарлотку", "Поднадкусываю", 4,2);
        addQuestion(q19);
        QuestionModel q20 = new QuestionModel ("Что часто добавляют в кондитерские изделия?", "Кокосовый лапник", "Кокосовые опилки", "Кокосовые щепки", "Кокосовую стружку", 4,2);
        addQuestion(q20);
        QuestionModel q21 = new QuestionModel ("Какой цвет отсутствует в радуге?", "Сиреневый", "Жёлтый", "Зелёный", "Фиолетовый", 1,3);
        addQuestion(q21);
        QuestionModel q22 = new QuestionModel ("Продолжите пословицу: Родину, как и родителей, на чужбине...", "Не найдёшь", "Потеряешь", "Забудешь", "Полюбишь", 1,3);
        addQuestion(q22);
        QuestionModel q23 = new QuestionModel ("Как заканчивается русская поговорка: Раз на раз...", "Не просчитывается", "Не выкидывается", "Не приходится", "Умножать бесполезно", 3,3);
        addQuestion(q23);
        QuestionModel q24 = new QuestionModel ("Какой праздник отмечается 14 февраля?", "Крещение", "День матери", "День ВДВ", "День влюблённых", 4,3);
        addQuestion(q24);
        QuestionModel q25 = new QuestionModel ("Как заканчивается название мультфильма Как Львёнок и Черепаха...", "Пели песню", "Сбежали на Мадагаскар", "Сочиняли стихи", "Поселились у Запашных", 1,3);
        addQuestion(q25);
        QuestionModel q26 = new QuestionModel ("Как называется устройство, стоящее на игровом столе программы Что? Где? Когда?", "Волчок", "Белочка", "Зайчонок", "Лисичка", 1,3);
        addQuestion(q26);
        QuestionModel q27 = new QuestionModel ("Какой химический элемент в таблице Менделеева обозначается 21-й буквой латинского алфавита?", "Уран", "Ванадий", "Кислород", "Фосфор", 1,3);
        addQuestion(q27);
        QuestionModel q28 = new QuestionModel ("В какой игре одному из участников завязывают глаза?", "Прятки", "Жмурки", "Салки", "Карты", 2,3);
        addQuestion(q28);
        QuestionModel q29 = new QuestionModel ("Как называется верхний слой атмосферы Солнца?", "Диадема", "Фотосфера", "Светосфера", "Корона", 4,3);
        addQuestion(q29);
        QuestionModel q30 = new QuestionModel ("Что надо сорвать, чтобы значительно улучшить своё благосостояние?", "Урок в школе", "Банк в казино", "Цветок с клумбы", "Поцелуй с губ", 2,3);
        addQuestion(q30);
        QuestionModel q31 = new QuestionModel ("Какая дама описана у Антона Павловича Чехова?", "С заначкой", "С собачкой", "С болячкой", "Со жвачкой", 2,4);
        addQuestion(q31);
        QuestionModel q32 = new QuestionModel ("Как звали кавказскую пленницу в одноименной комедии Леонида Гайдая?", "Ирина", "Арина", "Марина", "Нина", 4,4);
        addQuestion(q32);
        QuestionModel q33 = new QuestionModel ("Какого призыва нет в олимпийском девизе?", "Сильнее", "Быстрее", "Выше", "Дальше", 4,4);
        addQuestion(q33);
        QuestionModel q34 = new QuestionModel ("Сколько разных цифр потребуется для записи числа двенадцать миллионов семнадцать тысяч восемьсот тридцать два?", "Шесть", "Пять", "Семь", "Восемь", 1,4);
        addQuestion(q34);
        QuestionModel q35 = new QuestionModel ("Разновидностью какой ягоды в быту называют Аронию черноплодную?", "Калины", "Малины", "Рябины", "Брусники", 3,4);
        addQuestion(q35);
        QuestionModel q36 = new QuestionModel ("Как заканчивается пословица: Гусь свинье...", "Не подарит пера", "Не товарищ", "Накрутит хвоста", "Начистит пятачок", 2,4);
        addQuestion(q36);
        QuestionModel q37 = new QuestionModel ("На сколько можно опоздать, по мнению паровозика из Ромашкова, если не увидеть рассвет?", "На неделю", "На всю жизнь", "На месяц", "На год", 2,4);
        addQuestion(q37);
        QuestionModel q38 = new QuestionModel ("Где, согласно Библии, располагался Эдем, откуда были изгнаны Адам и Ева?", "На Солнце", "На Венере", "На Земле", "На Луне", 3,4);
        addQuestion(q38);
        QuestionModel q39 = new QuestionModel ("В каком институте каждый абитуриент рассказывает приёмной комиссии басню?", "В историко-архивном", "В экономическом", "В техническом", "В театральном", 4,4);
        addQuestion(q39);
        QuestionModel q40 = new QuestionModel ("Как называется место для одного локомотива в железнодорожном депо?", "Сектор", "Гараж", "Ангар", "Стойло", 4,4);
        addQuestion(q40);
        QuestionModel q41 = new QuestionModel ("Как называется детская игрушка-неваляшка?", "Минька-Кинька", "Летка-Енка", "Дядька-Сядька", "Ванька-Встанька", 4,5);
        addQuestion(q41);
        QuestionModel q42 = new QuestionModel ("Какая система счисления лежит в основе работы компьютера?", "Двоичная", "Десятичная", "Восьмеричная", "Полуторная", 1,5);
        addQuestion(q42);
        QuestionModel q43 = new QuestionModel ("Как называлась деревня, в которой жили дядя Фёдор, Матроскин и Шарик?", "Простоквашино", "Молочное", "Йогуртово", "Простофилино", 1,5);
        addQuestion(q43);
        QuestionModel q44 = new QuestionModel ("Что использует ассистент режиссёра, обозначая съёмку очередного дубля кинофильма?", "Фейерверк", "Конфетти", "Гирлянду", "Хлопушку", 4,5);
        addQuestion(q44);
        QuestionModel q45 = new QuestionModel ("Закончите пословицу: Лес рубят...", "Птицы сидят", "Щепки летят", "Звери бегут", "Дровосеки", 2,5);
        addQuestion(q45);
        QuestionModel q46 = new QuestionModel ("Какой документ сопровождает груз при перевозке?", "Докладная", "Накладная", "Закладная", "Прикладная", 2,5);
        addQuestion(q46);
        QuestionModel q47 = new QuestionModel ("Что, как принято считать, есть в головном мозге человека?", "Пружины", "Каляки-маляки", "Извилины", "Загогулины", 3,5);
        addQuestion(q47);
        QuestionModel q48 = new QuestionModel ("Государственный флаг какой страны имеет форму квадрата?", "Монако", "Дании", "Мавритании", "Швейцарии", 4,5);
        addQuestion(q48);
        QuestionModel q49 = new QuestionModel ("Как закончить русскую пословицу Милые бранятся ...", "Только тешатся", "К дождю", "Кобыле легче", "Впору вешаться", 1,5);
        addQuestion(q49);
        QuestionModel q50 = new QuestionModel ("Что обычно вырастает у взрослого человека?", "Ребро смелости", "Зуб мудрости", "Сердце нежности", "Печень трезвости", 2,5);
        addQuestion(q50);
    }

    private void addQuestion(QuestionModel  question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.GAME_COUNT, question.getGameCount());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<QuestionModel> getAllQuestions() {

        Random r = new Random();
        int randomInt = r.nextInt(5) + 1;

        ArrayList<QuestionModel> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE game_count = " + randomInt, null);

        if (c.moveToFirst()) {
            do {
                QuestionModel  question = new QuestionModel ();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setGameCount(c.getInt((c.getColumnIndex(QuestionsTable.GAME_COUNT))));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}