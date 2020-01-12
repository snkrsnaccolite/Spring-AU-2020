#!/usr/bin/env node

let array = [ 13, 42, "The", "answer", "to", "everything", 42, 0, "" ];
console.log("Initial Array: ", array);

// Array#filter
console.log("\nArray#filter");
console.log(array.filter(e => typeof e === "string"));

// Array#every
console.log("\nArray#every");
console.log(array.every(e => typeof e === "number"));

// Array#forEach
console.log("\nArray#forEach");
array.forEach(e => console.log(e));

// Array#indexOf
console.log("\nArray#indexOf");
console.log(array.indexOf(42));

// Array#join
console.log("\nArray#join");
console.log(array.join(" - "));

// Array#lastIndexOf
console.log("\nArray#lastIndexOf");
console.log(array.lastIndexOf(42));

// Array#map
console.log("\nArray#map");
console.log(array.map(e => !!e));

// Array#pop
console.log("\nArray#pop");
console.log(array.pop(), array);

// Array#push
console.log("\nArray#push");
console.log(array.push("Sankarsan"), array);

// Array#reduce
console.log("\nArray#reduce");
console.log([ 1, 3, 3, 7 ].reduce((a, c) => a + c, 0));

// Array#reduceRight
// Same as `reduce`, but right-to-left
console.log("\nArray#reduceRight");
console.log([ 1, 3, 3, 7 ].reduceRight((a, c) => a + c, 0));

// Array#reverse
console.log("\nArray#reverse");
console.log(array.reverse());

// Array#shift
console.log("\nArray#shift");
console.log(array.shift(), array);

// Array#unshift
console.log("\nArray#unshift");
console.log(array.unshift("Sankarsan"), array);

// Array#sort
console.log("\nArray#sort");
console.log([ '🥚', '🐔' ].sort());
console.log([ 1, 622, 124, 41, 0, 2  ].sort((a, b) => b - a));

// Array#some
console.log("\nArray#some");
console.log(array.some(e => e === 0));

// Array#splice
console.log("\nArray#splice");
console.log(array.splice(array.indexOf("everything"), 1), array);

// Array#slice
console.log("\nArray#slice");
console.log(array.slice(1, -3));
