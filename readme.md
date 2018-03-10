1. Clone and run **jitwatch**

```bash
sudo apt-get install openjfx maven       
git clone --depth 1 git@github.com:AdoptOpenJDK/jitwatch.git
cd jitwatch
mvn clean install -DskipTests=true
./launchUI.sh
```

2. Click on "Open Log" and input "hotspot.log" (You can run "EscapeAnalysisTest.bash" to generate a hotspot log yourself )
3. Click on "Config" and add "./src" in "Source locations" and add "./out" in "Class locations"