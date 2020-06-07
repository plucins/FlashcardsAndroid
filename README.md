# FlashcardsAndroid

## Description
  Application supporting language learning process. The main functionalities are quizzes and flashcards. At this stage the app supports only english language, in the future we hope to add more.
  
## Team 
  Sławek (s15976) Adam (s15814)
  
## Tools 
  ### Trello (Task tracker)
  ### Github (Code tracker) 

## Guide to running the monkey test
 - Make sure that app and emulator is up and running
 - Move to Android SDK folder -- platforms-tools -- where adb command run
    `cd AppData\Local\Android\Sdk\platform-tools
 - Copy following command
    `adb -e shell monkey -p com.example.flashcardsandroid 1000

