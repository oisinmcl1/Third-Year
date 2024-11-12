#lang racket

; Question 3
; Oisin Mc Laughlin - 22441106

(provide sortedDisplay)

; A - Display in sorted order the contents of a binary search tree

; First I'm going to create the tree itself using lists.
; Parent: 10
; LHS Node: 5, Left Child: 3, Right Child: 8
; RHS Node: 12 Right Child: 14

; left middle right

(define tree
  '(
    (
     ; LHS Child of 5
     (0 3 0)
     
     ; LHS Node
      5
      
      ; RHS Child of 5
     (0 8 0)
     )

    
    ; Right child of 5: Node 8 with no children
    10

    
    ; LHS Child of 12 empty (0)
    (0

     ; Right Node
     12

     ; RHS Child of 12
     (0 14 0)
     )
    )
  )    ; Right child of 12: Node 14 with no children




; Now a function to display tree in sorted order, as this is a BST it's already sorted (LHS less etc..)
(define (sortedDisplay tree)
  (cond
    ; if the tree us 0 there is nothing to do just return empty
    [(equal? tree 0) '()]

    ; otherwise traverse tree in sorted order
    [else
     
     ; left subtree traverse
     (sortedDisplay (car tree))

     ; display each value
     (display (cadr tree))
     (display "\n")

     ; now right tree
     (sortedDisplay (cadr (cdr tree)))
     ]
    )
  )

(sortedDisplay tree)


(display "\n\n")


; B - Return #t or #f if a given item is present or absent in a tree or not
(define (itemPresent tree item)
  (cond
    ; as always check if tree is empty and just return false if that's the case
    [(null? tree) #f]

    ; as well check if it's 0 and return f if so
    [(equal? tree 0) #f]

    ; check if item is present
    [(equal? item (cadr tree)) #t]

    ; otherwise search rest of the tree using recurssion and using or which will evauluate both left and right
    [else
     (or
      ; search left
      (itemPresent (car tree) item)
      ; search right
      (itemPresent (cadr (cdr tree)) item)
      )
     ]
    )
  )

; true
(itemPresent tree 14)
; false
(itemPresent tree 15)
