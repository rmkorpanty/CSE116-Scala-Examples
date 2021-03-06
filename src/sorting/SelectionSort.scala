package sorting

import sorting.inheritance.{Animal, Cat, Dog}

object SelectionSort {

  def intSelectionSort(inputData: List[Int], comparator: (Int, Int) => Boolean): List[Int] = {

    // copy only the reference of the input
    var data: List[Int] = inputData

    for (i <- data.indices) {

      // find the min value/index from i to the end of the list
      var minFound = data.apply(i)
      var minIndex = i
      for (j <- i until data.size) {
        val currentValue = data.apply(j)

        // make decisions based on the given comparator (this function can be thought of as a less than operator)
        if (comparator(currentValue, minFound)) {
          minFound = currentValue
          minIndex = j
        }
      }

      // swap the value at i with the min value
      data = data.updated(minIndex, data.apply(i))
      data = data.updated(i, minFound)
    }

    // return the new list
    data
  }

  def intSortingExample(): Unit = {
    val numbers = List(5, -23, -8, 7, -4, 10)
    val numbersSorted = intSelectionSort(numbers, (a: Int, b: Int) => a > b)
    println(numbersSorted)
  }


  def genericSortingExample(): Unit = {
    val animals: List[Animal] = List(new Cat("morris"), new Dog("Finn"), new Dog("Snoopy"), new Cat("Garfield"))
    val animalsSorted = selectionSort(animals, Animal.compareAnimals)
    println(animalsSorted)
  }


  def selectionSort[Type](inputData: List[Type], comparator: (Type, Type) => Boolean): List[Type] = {
    var data: List[Type] = inputData
    for (i <- data.indices) {
      var minFound = data.apply(i)
      var minIndex = i
      for (j <- i until data.size) {
        val currentValue = data.apply(j)
        if (comparator(currentValue, minFound)) {
          minFound = currentValue
          minIndex = j
        }
      }
      data = data.updated(minIndex, data.apply(i))
      data = data.updated(i, minFound)
    }
    data
  }


  def largeExample(): Unit = {
    val numbers: List[Double] = (for (_ <- 0 to 2000) yield Math.random()).toList
    selectionSort(numbers, (x: Double, y: Double) => x < y)
    println(numbers)
  }

  def main(args: Array[String]): Unit = {
    intSortingExample()
    genericSortingExample()
    largeExample()
  }

}
