package ashburncode.sbapp2717g;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class SyspropsController {

	@Operation(summary = "sysprops returns a selected subset of the Java system properties")  // works
	// @ApiOperation(summary = "sysprops returns a selected subset of the Java system properties")
	@GetMapping("/sysprops")
	public String sysprops() {
		// System.getProperties().list(System.out);
		String ls = System.getProperty("line.separator");
		String[] syspropnames = { "catalina.base", // C:\Users\DavidHolberton\AppData\Local...
				"catalina.home", // C:\Users\DavidHolberton\AppData\Local...
				"java.class.version", // 61.0
				"java.home", // C:\LocalApps\jdk-17.0.12+7
				"java.runtime.name", // OpenJDK Runtime Environment
				"java.runtime.version", // 17.0.12+7
				"java.specification.vendor", // Oracle Corporation
				"java.specification.version", // 17
				"java.vendor.url.bug", // https://github.com/adoptium/adoptium-...
				"java.vendor.url", // https://adoptium.net/
				"java.vendor.version", // Temurin-17.0.12+7
				"java.vendor", // Eclipse Adoptium
				"java.version.date", // 2024-07-16
				"java.version", // 17.0.12
				"java.vm.name", // OpenJDK 64-Bit Server VM
				"java.vm.specification.vendor", // Oracle Corporation
				"java.vm.specification.version", // 17
				"java.vm.vendor", // Eclipse Adoptium
				"java.vm.version", // 17.0.12+7
				"os.name", // Windows 11
				"os.version", // 10.0
				"user.dir", // C:\Users\DavidHolberton\sbprojs\hello...
				"user.home", // C:\Users\DavidHolberton
				"user.name", // DavidHolberton
				"user.timezone" };
		StringBuffer sb = new StringBuffer("Greetings from Hello Nebula");
		for (String syspropname : syspropnames) {
			String syspropvalue = System.getProperty(syspropname);
			sb.append(ls + " " + syspropname + " = " + syspropvalue);
		}
		return sb.toString();
	}

	@Operation(summary = "sysprops value string", description = "sysprops notes string") 
	@GetMapping("/sysprop/syspropNameViaPathVariable/{syspropname}")
	public String syspropNameViaPathVariable(@PathVariable String syspropname) {
		String syspropvalue = System.getProperty(syspropname.trim());
		return "syspropname: " + syspropname + ", syspropvalue: " + syspropvalue;
	}

	@Operation(summary = "sysprops value string")
	@GetMapping("/sysprop/syspropNameViaRequestParameter")
	public String syspropNameViaRequestParameter(@RequestParam String syspropname) {
		String syspropvalue = System.getProperty(syspropname.trim());
		return "syspropname: " + syspropname + ", syspropvalue: " + syspropvalue;
	}

	@Operation(summary = "sysprops value string", description = "sysprops notes string") 
	// @ApiOperation(notes = "sysprops notes string") // fails
	@GetMapping("/sysprop/syspropNameViaRequestHeader")
	public String syspropNameViaRequestHeader(
			@RequestHeader(required = true) String syspropname) {
		String syspropvalue = System.getProperty(syspropname.trim());
		return "syspropname: " + syspropname + ", syspropvalue: " + syspropvalue;
	}

}

// -- listing properties --
// catalina.base=C:\Users\DavidHolberton\AppData\Local...
// catalina.home=C:\Users\DavidHolberton\AppData\Local...
// catalina.useNaming=false
// CONSOLE_LOG_CHARSET=windows-1252
// file.encoding=windows-1252
// file.separator=\
// FILE_LOG_CHARSET=windows-1252
// java.awt.headless=true
// java.class.path=C:\Users\DavidHolberton\sbprojs\hello...
// java.class.version=61.0
// java.home=C:\LocalApps\jdk-17.0.12+7
// java.io.tmpdir=C:\Users\DAVIDH~1\AppData\Local\Temp\
// java.library.path=C:\LocalApps\jdk-17.0.12+7\bin;C:\WIN...
// java.runtime.name=OpenJDK Runtime Environment
// java.runtime.version=17.0.12+7
// java.specification.name=Java Platform API Specification
// java.specification.vendor=Oracle Corporation
// java.specification.version=17
// java.vendor.url.bug=https://github.com/adoptium/adoptium-...
// java.vendor.url=https://adoptium.net/
// java.vendor.version=Temurin-17.0.12+7
// java.vendor=Eclipse Adoptium
// java.version.date=2024-07-16
// java.version=17.0.12
// java.vm.compressedOopsMode=Zero based
// java.vm.info=mixed mode, emulated-client, sharing
// java.vm.name=OpenJDK 64-Bit Server VM
// java.vm.specification.name=Java Virtual Machine Specification
// java.vm.specification.vendor=Oracle Corporation
// java.vm.specification.version=17
// java.vm.vendor=Eclipse Adoptium
// java.vm.version=17.0.12+7
// jdk.debug=release
// line.separator=
// LOGGED_APPLICATION_NAME=[hellonebula]
// native.encoding=Cp1252
// os.arch=amd64
// os.name=Windows 11
// os.version=10.0
// path.separator=;
// PID=15624
// sun.arch.data.model=64
// sun.boot.library.path=C:\LocalApps\jdk-17.0.12+7\bin
// sun.cpu.endian=little
// sun.cpu.isalist=amd64
// sun.io.unicode.encoding=UnicodeLittle
// sun.java.command=com.ashburncode.hellonebula.Hellonebu...
// sun.java.launcher=SUN_STANDARD
// sun.jnu.encoding=Cp1252
// sun.management.compiler=HotSpot 64-Bit Tiered Compilers
// sun.os.patch.level=
// user.country=US
// user.dir=C:\Users\DavidHolberton\sbprojs\hello...
// user.home=C:\Users\DavidHolberton
// user.language=en
// user.name=DavidHolberton
// user.script=
// user.timezone=America/New_York
// user.variant=
