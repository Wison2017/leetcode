class Solution:
    def calculate(self, s):
        num_stack = []
        ops_stack = []
        length = len(s)
        i = 0
        while i < length:
            c = s[i]
            if c == '(':
                ops_stack.append(c)
            elif c == ')':
                op = ops_stack.pop()
                while op != '(':
                    num1 = num_stack.pop()
                    num2 = num_stack.pop()
                    result = num2 + num1 if op == '+' else num2 - num1
                    num_stack.append(result)
                    op = ops_stack.pop()
            elif c == '+':
                if not ops_stack:
                    ops_stack.append(c)
                elif ops_stack[-1] == '+':
                    num1 = num_stack.pop()
                    num2 = num_stack.pop()
                    result = num2 + num1
                    num_stack.append(result)
                elif ops_stack[-1] == '-':
                    ops_stack.pop()
                    num1 = num_stack.pop()
                    num2 = num_stack.pop()
                    result = num2 - num1
                    num_stack.append(result)
                    ops_stack.append(c)
                elif ops_stack[-1] == '(':
                    ops_stack.append(c)
            elif c == '-':
                if not ops_stack:
                    ops_stack.append(c)
                elif ops_stack[-1] == '+':
                    ops_stack.pop()
                    num1 = num_stack.pop()
                    num2 = num_stack.pop()
                    result = num2 + num1
                    num_stack.append(result)
                    ops_stack.append(c)
                elif ops_stack[-1] == '-':
                    num1 = num_stack.pop()
                    num2 = num_stack.pop()
                    result = num2 - num1
                    num_stack.append(result)
                elif ops_stack[-1] == '(':
                    ops_stack.append(c)
            elif c == ' ':
                i += 1
                continue
            else:
                num = int(c)
                i += 1
                while i < length:
                    c = s[i]
                    if c >= '0' and c <= '9':
                        num = num * 10 + int(c)
                        i += 1
                    else:
                        break
                i -= 1
                num_stack.append(num)
            i += 1
        while ops_stack:
            num1 = num_stack.pop()
            num2 = num_stack.pop()
            op = ops_stack.pop()
            if op == '+':
                result = num2 + num1
            else:
                result = num2 - num1
            num_stack.append(result)
        return num_stack.pop()
