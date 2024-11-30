% Assignment 3 - Q1
% Oisin Mc Laughlin - 22441106
% cd('Desktop/year3/ProgrammingParadigms/Assignment3Prolog').

% write a prolog query that displays the head and tail of the list [1,2,3].
% ?- [H | T] = [1, 2, 3].

% use a nested list to display the head of the list, the head of the tail of the list and the tail of the tail of the list [1 ,2,3,4,5].
% ?- [H|[TH|TT]] = [1,2,3,4,5].

% Write a prolog rule ‘contains1’ that returns true if a given element is the first element of a given list.
contains1(X, [X | _]).

% testing with
% ?- contains1(1, [1, 2, 3]).
% ?- contains1(2, [1, 2, 3]).

% Write a prolog rule ‘contains2’ that returns true if a given list is the same as the tail of another given list
contains2(Y, [X | Y]).

% Write a prolog query using 'contains1' to display the first element of a given list.
% contains1(Fst, [1,2,3]).
