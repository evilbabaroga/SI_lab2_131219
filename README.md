# Втора лабораториска вежба по Софтверско инженерство

## Кристијан Лазевски, бр. на индекс 131219

### Група на код:

Ја добив групата на код 2

### Control Flow Graph


![...](https://i.imgur.com/Xo3zbFW.png)


    public boolean function (User user, List<String> allUsers) { // A  
      if (user==null) { // B  
      throw new RuntimeException("The user argument is not initialized!"); // C  
      }  
        else {  
            if (user.getUsername()==null || allUsers.contains(user.getUsername())) { // D  
      throw new RuntimeException("User already exists!"); // E  
      }  
            else {  
                if (user.getEmail()==null) // F  
      return false; // G  
      boolean atChar = false, dotChar = false; // H  
      for (int i=0;i<user.getEmail().length();i++) { // I  
      if (user.getEmail().charAt(i)=='@') // J  
      atChar = true; // K  
      if (atChar && user.getEmail().charAt(i)=='.') { // L  
      dotChar = true; // M  
      }  
                }  
                if (!atChar || !dotChar) { // N  
      return false; // O  
      }  
            }  
        }  
        return true; // P  
    }


### Цикломатска комплексност

Вредноста е 5
18 ребра - 15 јазли + 2 = 5

### Тест случаи според критериумот Multiple-Condition

    1.  null, null
    2.  {null, null, null}, null
    3.  {'aaa', null, null}, [{'aaa', null, null}]   
    4.  {'aaa', null, null}, []  
    5.  {'aaa', null, 'aaa'}, []
    6.  {'aaa', null, '@'}, []
    7.  {'aaa', null, '@.'}, []

### Тест случаи според критериумот Every branch

....

### Објаснување на напишаните unit tests

Multiple-Condition:

	1. user == null

|Combination|Possible test case|Branch|
|--|--|--|
| T | null, null | AB-C |
| F | {null, null, null}, null | AB-D |

	2. user.getUsername() == null || allUsers.contains(user.getUsername())

|Combination|Possible test case|Branch|
|--|--|--|
| TX | {null, null, null}, []| D-E |
| FT | {'aaa', null, null}, ['aaa'] | D-E |
| FF | {'aaa', null, null}, [] | D-F |

	3. user.getEmail == null

|Combination|Possible test case|Branch|
|--|--|--|
| T | {'aaa', null null}, []| F-G |
| F | {'aaa', null, 'aaa'}, []| F-H |

	4. user.getEmail().charAt(i) == '@'

|Combination|Possible test case|Branch|
|--|--|--|
| T | {'aaa', null '@'}, []| J-K |
| F | {'aaa', null, 'aaa'}, []| J-L |

	5. atChar && user.getEmail().charAt(i)=='.'

|Combination|Possible test case|Branch|
|--|--|--|
| TT | {'aaa', null '@.'}, []| L-M |
| TF | {'aaa', null, '@'}, []| L-I |
| FX | {'aaa', null, 'aaa'}, []| L-I |

	6. !atChar || !dotChar

|Combination|Possible test case|Branch|
|--|--|--|
| TX| {'aaa', null 'aaa'}, []| N-O |
| FT| {'aaa', null, '@'}, []| N-O |
| FF | {'aaa', null, '@.'}, []| N-P |