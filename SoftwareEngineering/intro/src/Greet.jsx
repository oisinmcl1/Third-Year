function Welcome(props) {
    return <h1>Hello, {props.name}!</h1>
}

function Welcome2(props) {
    const person = props.name;

    if (person) {
        return <h1>Hello, {person}!</h1>
    }
    return <h1>Hello, stranger!</h1>
}

//export default Welcome
export default Welcome2