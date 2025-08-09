cat > projects/haken/README.md << EOF
# Basic Java Project

- **JDK Version**: 1.8
- **Build Tool**: No
- **Main**: haken.Main

## Run method
\`\`\`bash
javac -d bin src/haken/*.java
java -cp bin haken.Main
\`\`\`

## Development Environment Requirements

### Essential components
- **JDK**: [Eclipse Temurin 8](https://adoptium.net/temurin/releases/?version=8)
- **Eclipse IDE**: 2023-12 or higher version

### Configuration steps
1. Install JDK:
   ```bash
   brew install --cask temurin8
   ```

2. Set up in Eclipse:
   ```
   Preferences → Java → Installed JREs
   → Add → Standard VM
   → JRE home: /Library/Java/JavaVirtualMachines/temurin-8.jdk/Contents/Home
   ```

3. Verify Environment:  
   ### Before the first time execution  
   1. Grant script execution permissions:  
      ```bash  
      chmod +x verify_environment.sh  
      ```  
   2. Run the verify script:  
      ```bash  
      ./verify_environment.sh  
      ```  
   ### Expected Output：  
   Display when successfully:  
   ```	 
   === Environmental validation starts ===  
   === Verification Results ===  
   JDK Path: /Library/Java/JavaVirtualMachines/temurin-8.jdk/Contents/Home  
   Java Version: openjdk version "1.8.0_382"  
   === Validation Passed ===  
   
   If it fails, it will prompt you with specific errors and repair suggestions.  

   Recommendation: Check project properties in Eclipse -> Java Compiler settings  
EOF
