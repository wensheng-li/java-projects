cat > projects/jdk8-simple-project/README.md << EOF
# Basic Java Project

- **JDK Version**: 1.8
- **Build Tool**: No
- **Main**: haken.Main

## Run method
\`\`\`bash
javac -d bin src/haken/*.java
java -cp bin haken.Main
\`\`\`
EOF
