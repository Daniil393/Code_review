#include "calc_tree.h"

#include <iostream>
#include <sstream>
#include <cmath>
#include <stack>

std::shared_ptr<TreeNode> CalcTree::build_tree(const std::string& expr, size_t& pos) {
  while (pos < expr.length() && isspace(expr[pos])) {
    pos++;
  }

  if (pos >= expr.length()) {
    return nullptr;
  }

  if (expr[pos] == '+' || expr[pos] == '-' || expr[pos] == '*' ||
    expr[pos] == '/' || expr[pos] == '%' || expr[pos] == '^') {

    /*
    FIX_ME: имя переменной должно соответствовать
    стилю lower_case_with_underscores.

    int opCode;
    switch (expr[pos]) {
    case '+': opCode = add; break;
    case '-': opCode = sub; break;
    case '*': opCode = mul; break;
    case '/': opCode = div; break;
    case '%': opCode = mod; break;
    case '^': opCode = pow_; break;
    default: opCode = 0;
    }
    pos++;

    auto node = std::make_shared<TreeNode>(opCode);
    */
    int op_code;
    switch (expr[pos]) {
    case '+': op_code = add; break;
    case '-': op_code = sub; break;
    case '*': op_code = mul; break;
    case '/': op_code = div_; break;
    case '%': op_code = mod; break;
    case '^': op_code = pow_; break;
    default: op_code = 0;
    }
    pos++;

    auto node = std::make_shared<TreeNode>(op_code);
    node->left = build_tree(expr, pos);
    node->right = build_tree(expr, pos);
    return node;
  }

  if (isdigit(expr[pos])) {
    int num = expr[pos] - '0';
    pos++;
    return std::make_shared<TreeNode>(num);
  }

  return nullptr;
}

int CalcTree::evaluate(const std::shared_ptr<TreeNode>& node) {
  if (!node) return 0;

  if (node->value >= 0 && node->value <= 9) {
    return node->value;
  }

  /*
  FIX_ME: имена переменных должны соответствовать
  стилю lower_case_with_underscores.

  int leftVal = evaluate(node->left);
  int rightVal = evaluate(node->right);

  switch (node->value) {

  case add: return leftVal + rightVal;
  case sub: return leftVal - rightVal;
  case mul: return leftVal * rightVal;
  case div: return leftVal / rightVal;
  case mod: return leftVal % rightVal;
  case pow_: return static_cast<int>(pow(leftVal, rightVal));
  default: return 0;
  }
  */
  int left_val = evaluate(node->left);
  int right_val = evaluate(node->right);

  switch (node->value) {

  case add: return left_val + right_val;
  case sub: return left_val - right_val;
  case mul: return left_val * right_val;
  case div_: return left_val / right_val;
  case mod: return left_val % right_val;
  case pow_: return static_cast<int>(pow(left_val, right_val));
  default: return 0;
  }
}

void CalcTree::replace_power(std::shared_ptr<TreeNode>& node) {

  /*
  FIX_ME: не фигурных скобок в теле условия if.

  if (!node) return;
  */
  if (!node) {
    return;
  }

  if (node->value == pow_) {
    int result = evaluate(node);
    node = std::make_shared<TreeNode>(result);
    return;
  }

  replace_power(node->left);
  replace_power(node->right);
}

void CalcTree::build_from_string(const std::string& expression) {
  size_t pos = 0;
  root = build_tree(expression, pos);
}

void CalcTree::transform() {
  replace_power(root);
}

/*
FIX_ME: дерево выводилось некорректно
(выводилась его структура, а не математическая запись).

Удалены функции printTree и print.
*/
void CalcTree::print_tree(const std::shared_ptr<TreeNode>& node) {

  if (!node) {
    return;
  }

  if (node->value >= 0) {
    std::cout << node->value;
  }
  else {
    std::cout << "(";
    print_tree(node->left);
    std::cout << " " << decode_op(node->value) << " ";
    print_tree(node->right);
    std::cout << ")";
  }
}

char CalcTree::decode_op(int val) {
  switch (val) {
  case -1: return '+';
  case -2: return '-';
  case -3: return '*';
  case -4: return '/';
  case -5: return '%';
  case -6: return '^';
  }
  return '?';
}

//FIX_ME: реализация функции для вычисления результата выражения.
int CalcTree::evaluate() {
  return evaluate(root);
}
