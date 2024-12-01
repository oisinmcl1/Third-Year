% all list empty return empty
mergeLists([], [], [], []).

% add head first list to result
mergeLists([H1 | T1], List2, List3, [H1 | MergedTail]) :-
    mergeLists(T1, List2, List3, MergedTail).

% if first list empty, add head of second list
mergeLists([], [H2 | T2], List3, [H2 | MergedTail]) :-
    mergeLists([], T2, List3, MergedTail).

% if first and second lists empty add head of third list
mergeLists([], [], [H3 | T3], [H3 | MergedTail]) :-
    mergeLists([], [], T3, MergedTail).
