# TEMPOMAILO

## Description
A simple wrapper https://mail.tm/ API client that allows you to receive emails. Gererate random email address and read emails.

## Install

[![](https://jitpack.io/v/Evleaps/SafeCoroutines.svg)](https://jitpack.io/#Evleaps/SafeCoroutines)

Just add dependency

Gradle:
```groovy
    allprojects {
        repositories {
            // ...
            maven { url 'https://jitpack.io' }
        }
    }

    dependencies {
        implementation 'com.github.trudoliubov:tempomailo:$version'
    }
```
Maven:
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependency>
        <groupId>com.github.trudoliubov</groupId>
        <artifactId>tempomailo</artifactId>
        <version>$version</version>
    </dependency>
```

## Samples

```java
public MyClass() {
    Api tmMail = new Tempomailo();
    // Get domain
    String domain = tmMail.getDomains(1).getHydraMember().get(0).getDomain();
    // Get account
    String account = tmMail.getAccount(UUID.randomUUID() + "@" + domain, "12qw!@QW").getAddress();
    // Get token for account
    String token = tmMail.getToken(account, "12qw!@QW").getToken();
    // Get messages
    String messageId = tmMail.getMessages(token, 1).getHydraMember().get(0).getId();
    // Get message text by id
    String message = tmMail.getMessageById(messageId, token).getText();
}
```

## License
GNU General Public License v3.0
```
Read more: [LICENSE](LICENSE) file
```
