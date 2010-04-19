package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class ConceptTemplateSystem[TOut](templates : List[ConceptTemplate[TOut]])
extends TemplateSystem[ALConcept,TOut](templates)