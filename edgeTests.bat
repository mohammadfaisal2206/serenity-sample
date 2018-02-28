call mvn verify -Dcontext=edge -Dwebdriver.driver=edge -Dwebdriver.edge.driver="src\test\resources\drivers\MicrosoftWebDriver.exe"
call mvn serenity:aggregate