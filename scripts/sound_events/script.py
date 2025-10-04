import re
from pathlib import Path
import sys

# Input and output paths
INPUT_FILE = sys.argv[1] if len(sys.argv) > 1 else "in.txt"
OUTPUT_FILE = sys.argv[2] if len(sys.argv) > 2 else "out.txt"

regex_pattern = re.compile(r'public static .*? (\w+) = (?:block|blockAndItem)\(\s*"([^"]+)"')

# Events to generate
events = ["break", "step", "place", "hit", "fall"]

def main():
    java_code = Path(INPUT_FILE).read_text(encoding="utf-8")

    generated = []

    for match in regex_pattern.finditer(java_code):
        identifier, name = match.groups()
        identifier = identifier.upper()
        for ev in events:
            generated.append(
                f'public static final SoundEvent BLOCK_{identifier}_{ev.upper()} = soundEvent("block.{name}.{ev}");'
            )
        generated.append("")

    Path(OUTPUT_FILE).write_text("\n".join(generated), encoding="utf-8")
    print(f"out: {OUTPUT_FILE}")

if __name__ == "__main__":
    main()
