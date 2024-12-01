% if empty return empty (base)
reverseList([], []).

% reverse tail of list and append to head
% Recursive case: Reverse the tail of the list and append the head to the end.
reverseList([H | T], Reversed) :-
    % reverse tail
    reverseList(T, ReversedTail),
    % append head to reversed tail
    append(ReversedTail, [H], Reversed).
