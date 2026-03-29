---
name: Git Commit Message Generator
description: This skill generates clean, professional Git commit messages based on code changes.
---

# Skill: Git Commit Message Generator
## Description
This skill generates clean, professional Git commit messages based on code changes.

---

## When to Use
Use this skill when:
- User asks to write a commit message
- Code changes need to be summarized
- Git commits are being prepared

---

## Instructions
1. Analyze the provided changes
2. Identify:
   - What was added
   - What was updated
   - What was fixed

3. Generate commit message in this format:
<type>: <short summary>
- bullet point 1
- bullet point 2
- bullet point 3

4. Use standard commit types:
- feat → new feature
- fix → bug fix
- refactor → code improvement
- chore → minor changes
- docs → documentation

---

## Inputs
- Description of code changes

---

## Outputs
- A clean Git commit message

---

## Examples
### Input:
"Added login API integration and fixed validation issue"

### Output:
feat: integrate login API and fix validation issue
- added API call for login
- handled response and errors
- fixed form validation bug

---

## Constraints / Rules
- Keep summary under 10 words
- Use lowercase
- Be clear and concise
- No unnecessary text
