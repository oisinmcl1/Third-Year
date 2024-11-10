#lang racket

; Question 1
; Oisin Mc Laughlin - 22441106

; Part A

; 1
(display "A cons pair of two numbers: ")

(cons 8 9)

(display "\n")


; 2
(display "A list of 3 numbers, using only the cons function: ")

; For cons 3 the pair number needs to be a null value '()
(cons 1 (
         cons 2 (
                 cons 3 '()
                      )
              )
      )

(display "\n")

; 3
(display "A list containing a string, a number and a nested list of three numbers, using only the cons function: ")

(cons "Hello World!"
      (cons 99
            ; Put nested list in another cons
            (cons (cons 6
                        (cons 5
                              (cons 4 '()
                                    )
                              )
                        )
                  '()
                  )
            )
      )


(display "\n")


; 4
(display "A list containing a string, a number and a nested list of three numbers, using only the list function: ")

(list
 "World Hello!"
      12
       (list 9 8 7)
      )

(display "\n")


; 5
(display "A list containing a string, a number and a nested list of three numbers, using only the append function: ")

; First I will define 3 lists for the string, number and list of 3 numbers.
(define str '("!dlroW olleH"))
(define num '(420))
(define numL '(4 5 6))

(append str num numL)
