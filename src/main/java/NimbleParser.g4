parser grammar NimbleParser;

options { tokenVocab=NimbleLexer; }

// TODO! fixen
classModifier: 'global' | 'package' | 'internal';
fieldModifier: 'global' | 'package' | 'internal';
