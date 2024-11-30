% Assignment 3 - Q1
% Oisin Mc Laughlin - 22441106

takes(tom, ct331).
takes(mary, ct331).
takes(joe, ct331).
takes(tom, ct345).
takes(mary, ct345).
instructs(bob, ct331).
instructs(ann, ct345).

% Write a prolog rule called ‘teaches’ that returns true if a given instructor teaches a given student
teaches(X, Y) :- instructs(X, Z), takes(Y, Z).

% Write a prolog rule called ‘classmates’ that returns true if two students take the same course.
classmates(X,Y) :- takes(X, Z), takes(Y, Z).