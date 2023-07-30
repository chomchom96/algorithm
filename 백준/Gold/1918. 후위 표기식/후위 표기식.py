import sys

def comp(a, b):
    op = {'+': 1, '-': 1, '*': 2, '/': 2}
    return op.get(a, 0) >= op.get(b, 0)

def to_postfisx(infix):
    stack = []
    ans = []

    for c in infix:
        if c.isalpha():
            ans.append(c)
        elif c == '(':
            stack.append(c)
        elif c == ')':
            while stack and stack[-1] != '(':
                ans.append(stack.pop())
            stack.pop() 
        else:
            while stack and stack[-1] != '(' and comp(stack[-1], c):
                ans.append(stack.pop())
            stack.append(c)

    while stack:
        ans.append(stack.pop())

    return ''.join(ans)

print(to_postfisx(input()))