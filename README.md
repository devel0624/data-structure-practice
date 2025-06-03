# Data Structure with Java, Practice

## 01. MyArray

### 1. newInstance
- MyArray 인터페이스의 구현체 IntegerArray 객체를 생성합니다.

### 2. addElement
- IntegerArray 객체에 요소를 추가합니다.
    - 테스트 메서드의 파라미터인 정수 배열 array 의 요소를 모두 추가합니다.
    - 테스트 검증은 모든 요소가 추가되었는지 확인하기 위해 객체의 size() 메서드의 결과와 array 의 length 가 동일한지 확인합니다.

### 3. indexOf
- IntegerArray 에 특정 요소가 어느 위치에 있는지 확인합니다.
  - 테스트 메서드의 파리미터로 MyArray 타입의 객체가 전달됩니다.
  - 이 객체에서 target 이 어느 위치(index) 에 위치하는지 확인합니다.
  - 테스트 검증은 indexOf(element) 의 결과가 expected 와 동일한지 확인합니다.

### 4. getElement
- IntegerArray 의 특정 위치에 있는 요소를 얻습니다.
    - 테스트 메서드의 파리미터로 MyArray 타입의 객체가 전달됩니다.
    - 이 객체에서 특정 위치(target)에 있는 요소를 확인합니다.
    - 테스트 검증은 get(index) 의 결과가 expected 와 동일한지 확인합니다.

### 5. removeElement
- IntegerArray 에서 특정 요소를 제거합니다.
  - 테스트 메서드의 파리미터로 MyArray 타입의 객체가 전달됩니다.
  - 이 객체에서 특정 요소(removeTarget)을 제거합니다.
  - 테스트 검증은 제거되었는지 여부와 리스트가 비어있는지, 그리고 제거한 요소가 여전히 남아있는지 확인합니다.

### 6. iterableMyArray
- IntegerArray 에 대해 Iterable 을 구현합니다.
  - 조건문은 myArray 가 Iterable 객체인지 확인합니다.
  - iterable 을 foreach 문으로 반복하였을 때, 모든 요소가 myArray 에 존재하는지 확인합니다.

## 02. Domino

### 1. setUpDomino
- DominoLine 객체에 시작점 역할을 할 Domino 를 추가합니다.
  - DominoLine 에 Domino 가 추가되었는지 확인합니다.
  - 시작점 역할을 하는 도미노가 아직 넘어지지 않았는지 확인합니다.

### 2. toppleDomino
- `1. setUpDomino` 에서 세팅된 도미노를 넘어뜨립니다.
  - line.topple() 을 실행했을 때, 세팅된 도미노가 넘어져있는지 확인합니다.

### 3. toppleThreeDominoes
- `2. toppleDomino` 에 이어 시작 도미노 뒤에 추가로 두 개의 도미노를 세팅합니다.
  - line.topple() 을 실행했을 때, 세팅된 도미노가 모두 넘어지는지 확인합니다.

### 4. toppleSecondDomino
- `3. toppleThreeDominoes` 와 동일한 조건이지만 두 번째 도미노부터 넘어뜨립니다.
  - line.topple(2) 을 실행했을 때, 첫번쨰 도미노를 제외한 도미노가 모두 넘어지는지 확인합니다.

## 03. TextEditor

### 1. typeStartWord
- 텍스트에 첫 문자을를 입력합니다.
  - textEditor 의 toString() 을 실행했을 때의 결과가 expected 와 동일한지 확인합니다.

### 2. typeAppendWord
- `1. typeStartWord`의 결과에 추가로 문자열을 입력합니다.
  - `1. typeStartWord` 와 동일한 방법으로 append 문자열을 textEditor의 type 메서드로 전달합니다.
  - start 와 append 문자열을 이어붙인 결과와 동일한지 확인합니다.

### 3. typeInsertWord
- `2. typeAppendWord` 결과의 중간에 문자열을 입력합니다.
  - start 문자열 바로 뒤에 insert 문자열을 삽입합니다.
  - start, insert, append 를 순서대로 이어붙인 결과와 동일한지 확인합니다.

### 4. deleteWord
- `3. typeInsertWord` 결과에서 특정 문자열을 제거합니다.
  - 이전 테스트의 결과에서 start 문자열을 제거합니다.
  - insert 와 append 를 이어붙인 결과와 동일한지 확인합니다.

### 5. undoDeleteWord
- 이전에 한 행동을 취소(undo)하는 메서드를 구현합니다.
  - `4. deleteWord` 에서 실행한 start 문자열 제거를 취소합니다.
  - start, insert, append 를 순서대로 이어붙인 결과와 동일한지 확인합니다.

### 6. undoOverflow
- 취소 행위를 반복했을 때, 이전에 한 행위보다 많이 취소할 경우 에러가 발생하지 않는지 확인합니다.
  - textEditor 는 총 4회 동작하고, 취소를 5번 실행합니다.
  - 모든 행동을 취소한 결과가 비어있는지 확인합니다.

### 7. redoAfterType
- 취소한 행위를 다시 실행(redo)하는 메서드를 구현합니다.
  - undo 를 2회하고 redo 를 1회합니다.
  - 이후 추가로 문자열을 입력합니다.
  - 그리고 다시 redo 를 했을 때, 에러가 발생하지 않아야 합니다.
  - start, insert, append, beforeRedo 문자열을 순서대로 연결한 결과와 동일한지 확인합니다.

## 04. TaskProcessor

### 1. addTask
- taskProcessor 에 task 를 추가합니다.
  - taskA, taskB 를 추가했을 때,  taskProcessor 에서 대기 중 작업이 2개인지 확인합니다.

### 2. processOneTask
- 하나의 task 를 추가하고 작업을 합니다.
  - task 를 taskProcessor 에 추가합니다.
  - taskProcessor.process() 를 실행합니다
  - task.work() 메서드가 최소 1번 수행됐는지 확인합니다.

### 3. processLog
- taskProcessor 는 작업한 기록을 남깁니다.
  - taskA, taskB 를 추가합니다.
  - taskProcessor.process() 를 실행합니다
  - taskProcessor.getTaskLog() 의 결과가 expected 와 동일한지 확인합니다.

### 4. processTasks
- 작업량이 1 이상인 두 개의 작업을 수행합니다.
  - taskA, taskB 를 추가합니다.
  - taskProcessor.process();
  - taskA 와 taskB 의 메서드가 각각 작업 횟수만큼 수행됐는지 확인하고 taskProcessor.getTaskLog() 의 결과가 expected 와 동일한지 확인합니다.

## 05. BaseConverter

### 1. DecimalToBinary
- 10 진수를 같은 값의 2진수 문자열로 변환합니다.
  - baseConverter.convert(decimal, base) 를 실행합니다.
  - 변환 결과는 decimal 을 2진법으로 변환한 문자열입니다
  - 반복문을 사용하지 않고 Recursion 을 적용하여 풀이합니다.
  - 
### 2. DecimalToOctal
- 10 진수를 같은 값의 8진수 문자열로 변환합니다.
  - baseConverter.convert(decimal, base) 를 실행합니다.
  - 변환 결과는 decimal 을 8진법으로 변환한 문자열입니다
  - 반복문을 사용하지 않고 Recursion 을 적용하여 풀이합니다.
  - 
### 3. DecimalToHexadecimal
- 10 진수를 같은 값의 16진수 문자열로 변환합니다.
  - baseConverter.convert(decimal, base) 를 실행합니다.
  - 변환 결과는 decimal 을 16진법으로 변환한 문자열입니다
  - 반복문을 사용하지 않고 Recursion 을 적용하여 풀이합니다.
