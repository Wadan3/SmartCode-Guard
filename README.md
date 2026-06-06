# SmartCode-Guard 🤖🛡️

**AI-Powered Static Code Analysis & Vulnerability Scanner**

SmartCode-Guard is an engineering-focused tool designed to automate the detection of security vulnerabilities in Java source code. It leverages static analysis rules combined with AI-driven insights to ensure secure coding practices.

---

## 🏗️ Technical Architecture
The system is built with a modular, 3-layer architecture:

1.  **Parser Layer (`/src`):** Robust parsing logic to extract structural information from `.java` files.
2.  **Rule Engine (`/rules`):** A static analysis engine that identifies common security anti-patterns (e.g., plaintext credentials) before AI processing.
3.  **AI Engine (`/src`):** Interface designed for integration with LLMs (Large Language Models) to perform deep semantic vulnerability detection.

## 🛠️ Key Features
* **Static Rule Enforcement:** Pre-processing checks for immediate vulnerability identification.
* **Intelligent Analysis:** Prepares code snippets for LLM-based security audits.
* **Modular Design:** Highly extensible architecture for adding custom security rules.

## 📁 Project Structure
```text
SmartCode-Guard/
├── src/            # Core analysis engine (Parser + AI Interface)
├── rules/          # Static security rules definitions
├── tests/          # Vulnerable code samples for demonstration
├── reports/        # Generated vulnerability audit reports
└── docs/           # Technical documentation and architecture diagrams
