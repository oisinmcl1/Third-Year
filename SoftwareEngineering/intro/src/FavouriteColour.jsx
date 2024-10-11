import { useState } from 'react';

function FavouriteColour() {
    // Init state with default colour "red"
    const [colour, setColour] = useState("red");

    return (
        <>
            <h1>My favourite colour is {colour}!</h1>

            <button
                type="button"
                onClick={() => setColour("red")}
            >
                Red
            </button>

            <button
                type="button"
                onClick={() => setColour("green")}
            >
                Green
            </button>

            <button
                type="button"
                onClick={() => setColour("blue")}
            >
                Blue
            </button>
        </>
    )
}

export default FavouriteColour;