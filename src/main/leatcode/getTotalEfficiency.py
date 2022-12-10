#######
# Each team gets exactly two members
# The total skill for each team should be the same
# Find all unique pairings
# Map using Sets for Values?
#######
def getTotalEfficiency(skill):
    # Write your code here
    # If there isn't at least one return -1
    # Iterate over the array twice
    # Compare each member to the next calculating there total
    # Have a while loop running on the outside to be able to iterate over the original while loop if necessary
    # Have an array which can be shortened over time to search through it's values
    skill.sort(reverse=True)

    length = len(skill)

    sum = skill[0] + skill[length - 1]

    product = 0 # Result

    for i in range(0, int(length/2)):
        j = (length - 1 - i)
        if skill[i] + skill[j] == sum:
            product += (skill[i] * skill[j])
        else:
            return -1
    return product


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    skill_count = int(input().strip())

    skill = []

    for _ in range(skill_count):
        skill_item = int(input().strip())
        skill.append(skill_item)

    result = getTotalEfficiency(skill)

    fptr.write(str(result) + '\n')

    fptr.close()
