# DiamondAPI

## What the api can do ?
 - Easy Scoreboard
 - Easy tag management
 - Easy chat gestion
 - A simple connection creator for mysql and other in future...
 - Messages Utils (French)
 - Short game play utils

## How to install ?
 ### Maven :
 ```xml
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
 ```
 ```xml
	<dependency>
	    <groupId>com.github.LeDiamantRouge</groupId>
	    <artifactId>DiamondAPI</artifactId>
	    <version>433d19972f</version>
	</dependency>
 ```
 ### Gradle :
 ```xml
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
```
```xml
	dependencies {
		implementation 'com.github.LeDiamantRouge:DiamondAPI:433d19972f'
	}
```

## Exemples
### Chat :
```java
// Set global chat format
DiamondAPI.get().getChatManager().setChatFormat("§7%player%§f: %message%");

// Set chat format to a player
DiamondAPI.get().getChatManager().setPlayerFormat(player, "MyFormat -> §6%player% -> §f%message%");

// Reset the chat format for a player
DiamondAPI.get().getChatManager().setPlayerFormat(player, null);

// Get player chat format
String format_for_player = DiamondAPI.get().getChatManager().getPlayerChatFormat(player, message);
```
### Tag :
```java
// Set player tag prefix and suffix
DiamondAPI.get().getTagManager().setTagPrefix(player, "§4§lAdmin ");
DiamondAPI.get().getTagManager().setTagSuffix(player, " §fLEVEL 2");

// Reset player tag prefix and suffix
DiamondAPI.get().getTagManager().resetTag(player);
```
### ScoreBoard :
```java
// Register scoreboard player to scoreboard to display it
DiamondAPI.get().getScoreBoardManager().registerPlayer(player, "Default Title", Arrays.asList("This is", "the default", "lines for scoreboard"));

// Unregister scoreboard player to undisplay it
DiamondAPI.get().getScoreBoardManager().unRegisterPlayer(player);

// Set new title
DiamondAPI.get().getScoreBoardManager().setTitle(player, "new title");

// Set new lines
DiamondAPI.get().getScoreBoardManager().setLines(player, Arrays.asList("the new", "lines to add", "in scoreboard"));
```
### Database :
```java
// You can create a bdd in api and set a name to get it
DiamondAPI.get().getDataBaseManager().createConnectionAndConnect("BedwarsBDD", new DataBaseCredential("host.fr", 3306, "user", "pass", "bddName"));

// Get mysql connection after connected
Connection connection = DiamondAPI.get().getDataBaseManager().getConnection("BedwarsBDD");

// Disconnect a bdd
DiamondAPI.get().getDataBaseManager().removeConnection("BedwarsBDD");
```
### Messages :
```java
// Center a text in chat
player.sendMessage(MessageManager.centerText("Text is center in chat"));

// Parse second to last time (Like : 70 -> return 01:10)
String formatTime = MessageManager.secondsToFormatMinute(70);
```
And some other stuff...
