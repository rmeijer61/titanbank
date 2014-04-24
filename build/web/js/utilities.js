// Script 8.1 - utilities.js
// This script defines an object that has some utilitarian functions.

var U = {

    // For getting the document element by ID:
    $: function(id) {
        'use strict';
        if (typeof id == 'string') {
            return document.getElementById(id);
        }
    }, // End of $() function.

    // Function for setting the text of an element:
    setText: function(id, message) {
        'use strict';
        if ( (typeof id == 'string')
        && (typeof message == 'string') ) {
    
            // Get a reference to the element:
            var output = this.$(id);
            if (!output) return false;
        
            // Set the text
            if (output.textContent !== undefined) {
                output.textContent = message;
            } else {
                output.innerText = message;
            }
            return true;
        } // End of main IF.
    }, // End of setText() function.
    
    // Function for creating event listeners:
    addEvent: function(obj, type, fn) {
        'use strict';
        if (obj && obj.addEventListener) { // W3C
            obj.addEventListener(type, fn, false);
        } else if (obj && obj.attachEvent) { // Older IE
            obj.attachEvent('on' + type, fn);
        }
    }, // End of addEvent() function.
    
    // Function for removing event listeners:
    removeEvent: function(obj, type, fn) {
        'use strict';
        if (obj && obj.removeEventListener) { // W3C
            obj.removeEventListener(type, fn, false);
        } else if (obj && obj.detachEvent) { // Older IE
            obj.detachEvent('on' + type, fn);
        }
    }, // End of removeEvent() function.
	
	// Function to write an error to the console.
	writeConsoleError: function() {
		'use strict';
	    if (typeof window.console != "undefined") {
            if (arguments.length > 0) {
                // Join for graceful degregation
                var args = (arguments.length > 1) ? Array.prototype.join.call(arguments, " ") : arguments[0];

                // This is the standard; Firebug and newer WebKit browsers support this.
                try {
					console.error(args);
                    return true;
                } catch(e) {
                    // Newer Opera browsers support posting errors to their consoles.
                    try {
                        opera.postError(args);
                        return true;
                    } catch(e) {
                    }
                }
		    }
        }		

        // Catch all; a good old alert box.
        alert(args);
        return false;
    },

	// Function to write a line to the console log.
	writeConsoleLog: function() {
	    'use strict';
	    if (typeof window.console != "undefined") {
            if (arguments.length > 0) {
                // Join for graceful degregation
                var args = (arguments.length > 1) ? Array.prototype.join.call(arguments, " ") : arguments[0];

                // This is the standard; Firebug and newer WebKit browsers support this.
                try {
					console.log(args);
                    return true;
                } catch(e) {
                    // Newer Opera browsers support posting errors to their consoles.
                    try {
                        opera.postError(args);
                        return true;
                    } catch(e) {
                    }
                }
		    }
        }			

        // Catch all; a good old alert box.
        alert(args);
        return false;
    },
	
    trimString: function(string) {
	    'use strict';
        if (string) {
            var string = string.replace( /^\s+/g, "" ); // strip leading
			string.replace( /\s+$/g, "" );              // strip trailing
            return string;
        } else {
		    return false;
		}
    },
	
	// Pad a number with zeros for a specified length. Return a string.
    padNumberWith0: function(number, length) {
	    'use strict';
		if (number && length) {
            var newNumber = number.toString(); 
            var padNumberWith = ''; 
            if (length > newNumber.length) { 
                for (var i=0; i < (length - newNumber.length); i++) { 
                    padNumberWith += '0'; 
                } 
            } 
            return padNumberWith + number.toString();
        } else {
            this.writeConsoleError('num2StringPad0 error: ' + 'number=' + number + ', ' + 'length=' + length);
			return false;
		}		
    },

	// Function used for debugging.
    showDOM: function (objectId) {
	'use strict';
    var testObj = document.getElementById(objectId);
	    if (!testObj) {
	        alert('Test object is null');
	    } else {
	        alert('testObj: ' + testObj
	        + '\n'
	        + 'Window Event: ' + window.event
	        + '\n'
	        + '\n' + 'Node Object Properties' 
            + '\n' + 'attributes: ' + testObj.attributes.value
		    + '\n' + 'localName: ' + testObj.localName
	        + '\n' + 'nodeName: ' + testObj.nodeName
		    + '\n' + 'nodeType: ' + testObj.nodeType
		    + '\n' + 'nodeValue: ' + testObj.nodeValue
		    + '\n' + 'ownerDocument: ' + testObj.ownerDocument.id
		    + '\n' + 'parentNode: ' + testObj.parentNode.id
		    + '\n' + 'prefix: ' + testObj.prefix
		    + '\n' + 'textContent: ' + testObj.textContent
		    + '\n'
		    + '\n' + 'DOM Document Object Properties'
		    + '\n' + 'doctype: ' + testObj.doctype
		    + '\n' + 'documentElement: ' + testObj.documentElement
		    + '\n'
		    + '\n' + 'DOM Element Object Properties'
		    + '\n' + 'tagName: ' + testObj.tagName
		    + '\n'
		    + '\n' + 'HTML DOM HTMLElement Object Properties'
		    + '\n' + 'accessKey: ' + testObj.accessKey
		    + '\n' + 'className: ' + testObj.className
		    + '\n' + 'dir: ' + testObj.dir
		    + '\n' + 'id: ' + testObj.id
		    + '\n' + 'innerHTML: ' + testObj.innerHTML
		    + '\n' + 'lang: ' + testObj.lang
		    + '\n'
		    + '\n' + 'DOM Attr Object Properties'
		    + '\n' + 'isId: ' + testObj.isId
		    + '\n' + 'name: ' + testObj.name
		    + '\n' + 'ownerElement: ' + testObj.ownerElement
		    + '\n' + 'specified: ' + testObj.specified
		    + '\n' + 'value: ' + testObj.value
		    );
        }
	},
	
	
    testAlert: function() {
	    'use strict';
        alert('Test');
    },

	
	enableTooltips: function(id) {
	    'use strict';
	
		// Get a reference to the element:
		var elem = this.$(id);

		// Add four event handlers to the element:
		this.addEvent(elem, 'focus', this.showTooltip);
	    this.addEvent(elem, 'mouseover', this.showTooltip);
	    this.addEvent(elem, 'blur', this.hideTooltip);
	    this.addEvent(elem, 'mouseout', this.hideTooltip);
	
	}, // End of enableTooltips() function.

	showTooltip: function(e) {
	    'use strict';
	
		// Get the event object:
		if (typeof e == 'undefined') var e = window.event;

		// Get the event target:
		var target = e.target || e.srcElement;
		target.previousSibling.lastChild.style.visibility = 'visible';

	}, // End of showTooltip() function.

	hideTooltip: function(e) {
	    'use strict';
	
		// Get the event object:
		if (typeof e == 'undefined') var e = window.event;

		// Get the event target:
		var target = e.target || e.srcElement;
		target.previousSibling.lastChild.style.visibility = 'hidden';

	}, // End of hideTooltip() function.
	
	// adds error messages. Takes 2 args:the form element ID and msg
	addErrorMessage: function(id, msg) {
   		'use strict';
    
    	// Get the form element reference:
    	var elem = document.getElementById(id);
    
    	// Define the new span's ID value:
    	var newId = id + 'Error';
    
    	// Check for the existence of the span:
    	var span = document.getElementById(newId);
    	if (span) {
        	span.firstChild.value = msg; // Update
    	} else { // Create new.
    
        	// Create the span:
        	span = document.createElement('span');
        	span.id = newId;
			span.className = 'error'
        	span.appendChild(document.createTextNode(msg));
        
        	// Add the span to the parent:
        	elem.parentNode.appendChild(span);
        	elem.previousSibling.className = 'error';

    	} // End of main IF-ELSE.

	}, // End of addErrorMessage() function.

	// This function removes the error message.
	// It takes one argument: the form element ID.
	removeErrorMessage: function(id) {
   		'use strict';
    	// Get a reference to the span:
    	var span = document.getElementById(id + 'Error');
		if (span) {
    
	    	// Remove the class from the label:
	    	span.previousSibling.previousSibling.className = null;
	    	// Remove the span:
	    	span.parentNode.removeChild(span);

		} // End of IF.
    
	}, // End of removeErrorMessage() function.	

    enableSubmit: function() {
        'use strict';
	    var submitObj = U.$('submit');
	    submitObj.disabled = false;
    },

    disableSubmit: function() {
        'use strict';
	    var submitObj = U.$('submit');
	    submitObj.disabled = true;
    },
	
	getTabArrayName: function() {
    	var calledFromHTML = decodeURIComponent(document.documentURI);
	    calledFromHTML = calledFromHTML.slice(calledFromHTML.lastIndexOf("/")+1);
		var HTMLName = calledFromHTML.split(".");
		HTMLName = HTMLName[0];
		var tabArrayName = HTMLName + 'TabArray';
		return tabArrayName;
	},
	
    ENDOFUTILITIES: function() {
	    'use strict';
    }	
}; // End of U declaration.