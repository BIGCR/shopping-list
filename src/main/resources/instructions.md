# Software Engineer Technical Test

### Description

Your task is to develop a simple Java program that calculates the price of a shopping cart.

### Requirements

- Programming language: Java
- Expected duration: ~4 hours
- Deliverables: 
  - GitHub repo link _(if private, please invite user "imdevin567" to the project)_
  - Instructions on how to build + run (i.e. required Java version, command/task to run, etc)
  - A compiled JAR should be committed as well, in case we cannot build the project

### Details

There are four items at this store. You will only see these four items. Each item can appear in the cart multiple times. The prices are as follows:

- Apple: $0.25/each
- Orange: $0.30/each
- Banana: $0.15/each
- Papaya: $0.50/each; are available as "3 for the price of 2"

Discounts can be applied multiple times. In other words, 9 papayas would be the price of 6, and so on.

Your input will be a file with individual items each on separate lines. An example:

```
Apple
Papaya
Apple
Banana
Banana
Orange
Papaya
Banana
Apple
Orange
Orange
Papaya
Apple
```

Your output should contain the aggregated prices of each item, as well as the total dollar amount. An example:

```
Apple: $1.00
Orange: $0.90
Banana: $0.45
Papaya: $1.00
Total: $3.35
```

Format of the output is irrelevant, as long as the data is correct.

### Testing

Please create your own input files to test. We will test using a few input files created in the format above.

### Assessment

You have full creativity to build this application however you want, as long as it meets the criteria. Please keep it simple--success will not be defined by the amount of code written!
