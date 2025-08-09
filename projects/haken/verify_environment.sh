#!/bin/bash

# Project Environment Validation Tool
echo "=== Environmental validation starts ==="

# 1. Check the operating system
if [[ "$OSTYPE" != "darwin"* ]]; then
  echo "Warning: This script is primarily designed for macOS."
fi

# 2. Verify JDK version
REQUIRED_JDK="temurin-8"
JDK_PATH=$(/usr/libexec/java_home -v 1.8 2>/dev/null)

if [ -z "$JDK_PATH" ]; then
  echo "Error: No JDK 1.8 installation detected"
  echo "Please install: https://adoptium.net/temurin/releases/?version=8"
  exit 1
fi

# 3. Verify if it is Temurin
if [[ "$JDK_PATH" != *"$REQUIRED_JDK"* ]]; then
  echo "Warning: Detected non-Temurin JDK ($JDK_PATH)"
  echo "Recommended use Temurin JDK for best compatibility"
fi

# 4. Verify compiler settings (optional)
if [ -f ".settings/org.eclipse.jdt.core.prefs" ]; then
  COMPILER_LEVEL=$(grep "org.eclipse.jdt.core.compiler.compliance" .settings/org.eclipse.jdt.core.prefs | cut -d= -f2)
  if [ "$COMPILER_LEVEL" != "1.8" ]; then
    echo "Warning: The compiler compliance level should be 1.8. (Current: $COMPILER_LEVEL)"
  fi
else
  echo "Info: Eclipse compiler configuration not found"
fi

echo "=== Verification results ==="
echo "JDK Path: $JDK_PATH"
echo "Java Version: $(java -version 2>&1 | head -n 1)"
echo "Recommendation: Check project properties in Eclipse -> Java Compiler settings"

exit 0