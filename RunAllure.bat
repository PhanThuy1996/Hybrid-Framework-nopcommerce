set ProjectPath = %~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllureReportNG\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllureReport\*;%ProjectPath%libAllureReportNG\*;%ProjectPath%libExtentReportV5\*;%ProjectPath%libLog4j\*;%ProjectPath%libraries\*;%ProjectPath%libReportNG\*;%ProjectPath%libWebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerceText.xml"
pause