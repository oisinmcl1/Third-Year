% Empty list (base)
isNotElementInList(_, []).

% if el not in list
isNotElementInList(El, [X | Y]) :-
    % if el not equal to head
    El \= X, 
    % recurse through tail
    isNotElementInList(El, Y).