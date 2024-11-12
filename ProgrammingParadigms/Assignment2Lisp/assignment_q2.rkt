#lang racket

; Question 2
; Oisin Mc Laughlin - 22441106

(provide ins_beg)
(provide ins_end)
(provide cout_top_level)
(provide count_instances)
(provide count_instances_tr)
(provide count_instances_deep)

; A - Insert an element at beginning of list
(define (ins_beg el lst)
  ; Using cons create pair of el . lst
  (cons el lst)
  )

(ins_beg 'a '(b c d))
(ins_beg '(a b) '(b c d))


(display "\n\n")


; B - Insert an element at end of list
(define (ins_end el lst)
  ; Append el to end of lst (el must be a lst to be appended)
  (append lst
          (list el)
          )
  )

(ins_end 'a '(b c d))
(ins_end '(a b) '(b c d))


(display "\n\n")


; C - Count number of top levels
(define (cout_top_level lst)
  ; if list empty return 0
  (if (null? lst)
      0
      ; Using recurssion add 1 to count current top element and on rest of list
      (+ 1 (cout_top_level (cdr lst))
         )
      )
  )

(cout_top_level '(a (b c) (d (e f))))


(display "\n\n")


; D - Count the number of times an item occurs in a list
(define (count_instances item lst)
  (cond
    ; If list is empty, count is 0
    [(null? lst) 0]
    
    ; If first element matches item, increment count by 1
    [(equal? item (car lst))
     (+ 1 (count_instances item (cdr lst)))]

    ; Otherwise, continue w/o incrementing
    [else (count_instances item (cdr lst))])
  )

(define cList '(1 2 3 4 5 3 6 2 3))
(count_instances 2 cList)


(display "\n\n")


; E - Count number of items in a list using tail recurssion
(define (count_instances_tr item lst c)
  (cond
    ; return c (which is 0) when the list is empty
    [(null? lst) c]

    ; incr count if item matches
    [(equal? item (car lst))
     (count_instances_tr item (cdr lst) (+ 1 c))
     ]

     ; continue w/o incr if item does not match
    [else
     (count_instances_tr item (cdr lst) c)]
    )
  )


(count_instances_tr 3 cList 0)


(display "\n\n")


; F - Counts number of times that item occurs in list including sub lists of items
(define (count_instances_deep item lst)
  (cond
    ; you know the craic by this stage
    [(null? lst) 0]

    ; checking if first item is a list
    [(list? (car lst))
     ; check the first element as a sublist, then rest of list
     (+ (count_instances_deep item (car lst))
        (count_instances_deep item (cdr lst)))]

     ; if item matches, incr and continue
    [(equal? item (car lst))
     (+ 1 (count_instances_deep item (cdr lst)))]

    ; otherwise continue w/o incr
    [else
     (count_instances_deep item (cdr lst))]
    )
  )


(count_instances_deep 3 '(1 2 3 (3 4) (2 (3 3))))