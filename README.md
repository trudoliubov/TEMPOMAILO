# TEMPOMEILO

## Description
A simple wrapper https://mail.tm/ API client that allows you to receive emails. Gererate random email address and read emails.

## Install

[![](https://jitpack.io/v/Evleaps/SafeCoroutines.svg)](https://jitpack.io/#Evleaps/SafeCoroutines)

Just add dependency

```groovy
    allprojects {
        repositories {
            // ...
            maven { url 'https://jitpack.io' }
        }
    }

    dependencies {
        implementation 'com.github.trudoliubov:tempomeilo:$version'
    }
```

## Samples

```java
public MyClass() {
    Api api = new Api();
    // Get domain
    String domain = api.getDomains(1).getHydraMember().get(0).getDomain();
    // Get account
    String account = api.getAccount(UUID.randomUUID() + "@" + domain, "12qw!@QW").getAddress();
    // Get token for account
    String token = api.getToken(account, "12qw!@QW").getToken();
    // Get messages
    String messageId = api.getMessages(token, 1).getHydraMember().get(0).getId();
    // Get message text by id
    String message = api.getMessageById(messageId, token).getText();
}
```

## License
GNU General Public License v3.0
```
Read more: [LICENSE](LICENSE) file
```
