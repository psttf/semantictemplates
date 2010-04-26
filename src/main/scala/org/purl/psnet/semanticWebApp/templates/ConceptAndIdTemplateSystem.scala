package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class ConceptAndIdTemplateSystem[TOut](templates : List[ConceptAndIdTemplate[TOut]])
extends TemplateSystem[ConceptAndId,TOut](templates)