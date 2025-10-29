Simple Web Quiz App built with Sptring Boot and Thymeleaf.

Features:
- displays availiable qiuzzes with shor description.
- upon clicking the quiz title, the quiz starts.
- the questoin title is represented along side the answe options (only one correct).
- navigation via the Next, Previous, Submit and Retake quiz buttons:
  - Next button shows only if the last question is not reached
  - Previous buttons shows only if we are not currently on the firs page
  - Sumbit button show only when the last question is reached and submits the answers
  - Retake quiz starts the same quiz from the beginning
- results page is presented afte submitting the answes showin the incorrecly answered questions with the correct answers, how many were correcly answered and Home button leading to the home page

Requirements to run the application include:
- Jave 21 or higher
- Maven
- IDE like InteliJ
- Browser to visualize the html
