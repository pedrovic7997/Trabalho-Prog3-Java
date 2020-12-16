/*
 * NumberUtils.h
 *
 * Utility functions for number manipulation.
 *
 *  Created on: Jul 10, 2014
 *      Author: Vítor E. Silva Souza (vitorsouza@gmail.com)
 */

#ifndef NUMBERUTILS_H_
#define NUMBERUTILS_H_

#include <locale>
#include <string>
#include "NumPunctPTBR.h"

namespace cpp_util {

using namespace std;

/* Locale object for Brazilian Portuguese. */
static const locale LOCALE_PT_BR(locale(), new NumPunctPTBR());

/* Converts decimal numbers from textual format to double, following a locale configuration. */
double parsedouble(const string&, const locale&);

/* Converts decimal numbers from double format to text, following a locale configuration. */
string formatdouble(const double, const locale&);

/* Converts decimal numbers from double format to currency, following a locale configuration. */
string formatdoubleCurrency(const double, const locale&);

}
#endif
