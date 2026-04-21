package ru.maltsev.directory;

/*
FIX_ME: Необходимо явно импортировать используемые классы.

import java.util.*;
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Класс {@code TelephoneDirectory} представляет телефонный справочник,
 * который хранит пары "имя - телефон" и предоставляет методы для
 * добавления, удаления, поиска и фильтрации контактов.
 */
public class TelephoneDirectory {

    private final Map<String, String> directory = new HashMap<>();

    /**
     * Добавляет запись в справочник.
     *
     * @param phone номер телефона (не может быть null)
     * @param name  имя контакта (не может быть null)
     * @return предыдущий номер телефона для данного имени, если он существовал, иначе {@code null}
     * @throws NullPointerException если {@code name} или {@code phone} равны {@code null}
     */
    public String add(String phone, String name) {
        Objects.requireNonNull(name, "Имя не может быть null");
        Objects.requireNonNull(phone, "Телефон не может быть null");

        return directory.put(name, phone);
    }

    /**
     * Удаляет запись из справочника по имени.
     *
     * @param name имя контакта
     * @return удалённый номер телефона, или {@code null}, если запись не существовала
     */
    public String remove(String name) {
        return directory.remove(name);
    }

    /**
     * Получает номер телефона по имени контакта.
     *
     * @param name имя контакта
     * @return номер телефона, или {@code null}, если контакт не найден
     */
    public String getPhone(String name) {
        return directory.get(name);
    }

    /**
     * Проверяет, содержится ли имя в справочнике.
     *
     * @param name имя контакта
     * @return {@code true}, если имя существует, иначе {@code false}
     */
    public boolean containsName(String name) {
        return directory.containsKey(name);
    }

    /**
     * Проверяет, содержится ли телефон в справочнике.
     *
     * @param phone номер телефона
     * @return {@code true}, если телефон существует, иначе {@code false}
     */
    public boolean containsPhone(String phone) {
        return directory.containsValue(phone);
    }

    /**
     * Возвращает количество записей в справочнике.
     *
     * @return количество контактов
     */
    public int size() {
        return directory.size();
    }

    /**
     * Возвращает копию всех пар "имя - телефон".
     *
     * @return карта всех записей справочника
     */
    public Map<String, String> getAllPairs() {
        return new HashMap<>(directory);
    }

    /**
     * Возвращает массив всех имён контактов.
     *
     * @return массив имён
     */
    public String[] getAllNames() {
        return directory.keySet().toArray(new String[0]);
    }

    /**
     * Возвращает массив всех номеров телефонов.
     *
     * @return массив номеров телефонов
     */
    public String[] getAllPhones() {
        return directory.values().toArray(new String[0]);
    }

    /**
     * Возвращает массив имён контактов, начинающихся с указанного префикса.
     *
     * @param prefix префикс для фильтрации имён
     * @return массив имён, начинающихся с {@code prefix}
     */
    public String[] getNamesByPrefix(String prefix) {
        return directory.keySet().stream().filter(name -> name.startsWith(prefix)).toArray(String[]::new);
    }

    /**
     * Возвращает строковое представление справочника.
     * Каждая запись выводится в формате "имя - телефон" с новой строки.
     *
     * @return строковое представление всех записей
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : directory.entrySet()) {
            sb.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        return sb.toString().trim();
    }
}